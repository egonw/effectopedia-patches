<?php

/* Receives oauth access_code from user and creates, updates, or associates accordingly. */
/* Returns user profile in format expected by parseProfile method of User class */

define('CONFIG_PATH', dirname(__FILE__) . '/../Config.php');
if (!file_exists(CONFIG_PATH)) {
    echo "Please copy Config.example.php to Config.php and fill in the required details.";
    header("HTTP/1.0 500 Internal Server Error");
    exit;
}
require_once(CONFIG_PATH);
require_once(dirname(__FILE__) . '/AuthenticationUser.php');
require_once(dirname(__FILE__) . '/../vendor/autoload.php');

$config = new Config();
$sso = new \League\OAuth2\Client\Provider\GenericProvider([
    "clientId" => $config->client_id,
    "clientSecret" => "",
    "redirectUri" => "urn:ietf:wg:oauth:2.0:oob",
    "responseResourceOwnerId" => "sub",
    "urlAuthorize" => $config->authentication_url,
    "urlAccessToken" => $config->access_token_url,
    "urlResourceOwnerDetails" => $config->user_info_url
]);

if (!isset($_POST['authorization_code'])) {
    $url = $config->end_session_url;
    if ($url[strlen($url) - 1] !== "?") {
        $url .= "?";
    }
    $url .= "post_logout_redirect_uri=";

    $authUrl = $sso->getAuthorizationUrl(array(
        'scope' => 'profile email openid',
        'state' => 'desktop'
    ));

    $url .= rawurlencode($authUrl);

    header("Location: $url");
    exit;
}

try {
    $authorizationCode = $_POST['authorization_code'];
    $accessToken = $sso->getAccessToken('authorization_code', [
        'code' => $authorizationCode,
        'redirect_uri' => 'urn:ietf:wg:oauth:2.0:oob'
    ]);

    $resourceOwner = $sso->getResourceOwner($accessToken);
    $ssoId = $resourceOwner->getId();
    $userClaims = $resourceOwner->toArray();

    $dbConnection = Database::getConnection();
    $dbConnection->beginTransaction();

    $sqlColumnFragment = implode(", ", AuthenticationUser::getDatabasePropertyNames());
    $dbQuery = $dbConnection->prepare(
        "SELECT {$sqlColumnFragment} FROM `users` WHERE (`sso_id` = :sso_id OR `email` = :email) AND `email` != ''
         ORDER BY sso_id DESC, id DESC LIMIT 1");
    $dbQuery->execute(array("sso_id" => $ssoId, "email" => $userClaims['email'] ?? ""));

    $user = $dbQuery->fetchObject(AuthenticationUser::class);
    if (!$user) {
        $user = new AuthenticationUser();
    }
    $user->fillFromClaims($ssoId, $userClaims);

    $dbQueryParams = array();
    if ($user->id) {
        $sql = "UPDATE `users` SET ";
        foreach (AuthenticationUser::getDatabasePropertyNames() as $propertyName) {
            if ($propertyName === "id") {
                continue;
            }

            $sql .= "`$propertyName` = :$propertyName, ";
            $dbQueryParams[$propertyName] = $user->{$propertyName};
        }
        $sql = substr($sql, 0, strlen($sql) - 2);
        $sql .= " WHERE `id` = :id";
        $dbQueryParams['id'] = $user->id;

        $dbQuery = $dbConnection->prepare($sql);
        $dbQuery->execute($dbQueryParams);
    } else {
        $sql = "INSERT INTO `users` ({$sqlColumnFragment}) VALUES (";
        foreach (AuthenticationUser::getDatabasePropertyNames() as $propertyName) {
            $sql .= ":{$propertyName}, ";
            $dbQueryParams[$propertyName] = $user->{$propertyName};
        }
        $sql = substr($sql, 0, strlen($sql) - 2);
        $sql .= ");";

        $dbQuery = $dbConnection->prepare($sql);
        $dbQuery->execute($dbQueryParams);

        // Must be called before commit.
        $user->id = $dbConnection->lastInsertId();
    }

    $dbConnection->commit();

    $effectopediaProfile = implode(";", $user->toEffectopediaProfileArray());

    session_start();
    $_SESSION['user'] = $user->id;

    echo <<<HTML
<!--profile{$effectopediaProfile};profile-->
HTML;
}
catch (Exception $e) {
    error_log($e);

    if ($e instanceof \League\OAuth2\Client\Provider\Exception\IdentityProviderException) {
        header('HTTP/1.0 403 Forbidden');
        $response = $e->getResponseBody();
        if (is_array($response)) {
            echo "{$response['error']}: {$response['error_description']}";
        } else {
            echo $e->getMessage();
        }
    }
    else {
        header('HTTP/1.0 500 Internal Server Error');
        echo "Internal Error";
    }

    exit;
}
