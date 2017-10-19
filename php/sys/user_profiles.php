<?php
require_once(dirname(__FILE__) . '/../Config.php');
require_once(dirname(__FILE__) . '/../vendor/autoload.php');

try {
    $dbConnection = Database::getConnection();

    $config = new Config();
    $sso = new \League\OAuth2\Client\Provider\GenericProvider([
        "clientId" => $config->service_account_username,
        "clientSecret" => $config->service_account_password,
        "redirectUri" => "urn:ietf:wg:oauth:2.0:oob",
        "responseResourceOwnerId" => "sub",
        "urlAuthorize" => $config->authentication_url,
        "urlAccessToken" => $config->access_token_url,
        "urlResourceOwnerDetails" => $config->user_info_url
    ]);
    $accessToken = $sso->getAccessToken('client_credentials');
    $request = $sso->getAuthenticatedRequest("GET", $config->users_url, $accessToken);
    $ssoUsersPromise = $sso->getHttpClient()->sendAsync($request);

    $dbQuery = $dbConnection->query("SELECT `id`,`sso_id`,`email`,`options` FROM `users`");
    $rows = $dbQuery->fetchAll(PDO::FETCH_ASSOC);

    $ssoUsers = json_decode($ssoUsersPromise->wait()->getBody(), true);
    foreach ($ssoUsers as $index => $ssoUser) {
        $ssoUsers[$ssoUser['id']] = $ssoUser;
        unset($ssoUsers[$index]);
    }

    echo "<!--profiles";
    foreach ($rows as $row) {
        $ssoUser = $ssoUsers[$row['sso_id']] ?? array();

        $id = $row['id'];
        $displayName = $ssoUser['attributes']['preferred_display_name'][0] ?? null;
        $displayName = empty($displayName)
            ? trim(($ssoUser['firstName'] ?? null) . ' ' . ($ssoUser['lastName'] ?? null))
            : $displayName;
        $displayName = empty($displayName) ? $row['email'] : $displayName;
        $options = $row['options'];

        echo $id . '=' . $displayName;
        if (defined("GET_EFFECTOPEDIA_OPTIONS_FIELD")) {
            echo '=' . $options;
        }
        echo ';';
    }
    echo "profiles-->";
} catch (Exception $e) {
    header("HTTP/1.0 500 Internal Server Error");
    error_log($e);
}
