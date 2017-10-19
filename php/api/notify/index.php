<?php
if (!defined("ENVIRONMENT")) {
    header("HTTP/1.0 500 Internal Server Error");
    die("Environment is not defined.");
}

require_once(dirname(__FILE__) . '/../../Config.php');

$default_path = dirname(__FILE__) . "/../../rev/" . ENVIRONMENT . "/notify/";
$not = $_GET["notification"] ?? null;

$dbConnection = Database::getConnection();

if (empty($not)) {
    header("HTTP/1.0 400 Bad Request");
    exit;
}

if ((strcasecmp($not, "list") == 0) || (strcasecmp($not, "l") == 0)) {
    $dbQuery = $dbConnection->query("SELECT * FROM `notifications`");
    while ($row = $dbQuery->fetchObject()) {
        echo "{$row->notification} {$row->timestamp} {$row->user_id} {$row->file_name} {$row->status} {$row->revision}";
    }
} else if ((strcasecmp($not, "current") == 0) || (strcasecmp($not, "cur") == 0) || (strcasecmp($not, "c") == 0)) {
    $dbQuery = $dbConnection->query("SELECT MAX(revision) FROM `notifications` WHERE `status` >= '0'");
    echo $dbQuery->fetchColumn() ?? "0";
} else if ((strcasecmp($not, "commit") == 0)) {
    include("ntf.php");

    $userId = $_GET["user"] ?? null;
    $fileName = $_GET["file_name"] ?? null;
    $docSha = $_GET["key"] ?? null;
    $revision = $_GET["revision"] ?? null;

    if (empty($userId) || empty($fileName) || empty($docSha) || empty($revision)) {
        header("HTTP/1.0 400 Bad Request");
        exit;
    }

    // Prevent remote file inclusion and parent directory traversal attacks
    if (preg_match("/^([A-Za-z]+(\\.php)?)?$/i", $fileName) === 0) {
        header("HTTP/1.0 403 Forbidden");
        echo "Illegal path";
        exit;
    }

    if (!file_exists($default_path . $fileName)) {
        header("HTTP/1.0 404 Not Found");
        die("Notification file was not found.");
    }

    $dbQuery = $dbConnection->prepare(
        "INSERT INTO `notifications` (`timestamp`, `user_id`, `file_name`, `status`, `doc_sha`, `revision`)
         VALUES (NOW(), :userId, :fileName, 1, :docSha, :revision)");
    $dbQuery->execute(array(
        "userId" => $userId,
        "fileName" => $fileName,
        "docSha" => $docSha,
        "revision" => $revision
    ));

    $notifications = new Notifications($default_path . $fileName);
    $notifications->send();
}
