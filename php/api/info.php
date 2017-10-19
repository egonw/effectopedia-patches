<?php
require_once(dirname(__FILE__) . '/../Config.php');

$revision = $_GET["revision"] ?? null;
$number = $_GET["number"] ?? null;
$userid = $_GET["user"] ?? null;

if (empty($revision)) {
    header("HTTP/1.0 400 Bad Request");
    exit;
}

$dbConnection = Database::getConnection();

if ((strcasecmp($revision, "current") == 0) || (strcasecmp($revision, "cur") == 0) || (strcasecmp($revision, "c") == 0)) {
    $dbQuery = $dbConnection->query("SELECT MAX(revision) FROM `xmldump` WHERE `committed` = '0'");
    $revision = $dbQuery->fetchColumn();
} else if ((strcasecmp($revision, "get") == 0) || (strcasecmp($revision, "g") == 0)) {
    $userid = 0;
    $dbQuery = $dbConnection->prepare("INSERT INTO `xmldump` (`timestamp` , `user_id`) VALUES (NOW(), :userId)");
    $dbQuery->execute(array("userId" => $userid));
    $revision = $dbConnection->lastInsertId();
    if ($revision == 1) {
        $dbConnection->exec("UPDATE `xmldump` SET `timestamp` = NOW(), `committed` = '0' WHERE `revision` = 1");
    }
} else if ((strcasecmp($revision, "commit") == 0)) {
    if (empty($userid) || empty($number)) {
        header("HTTP/1.0 400 Bad Request");
        exit;
    }

    $dbQuery = $dbConnection->prepare(
        "UPDATE `xmldump` SET `timestamp` = NOW(), `committed` = '0', `user_id` = :userId WHERE `revision` = :revision");
    $dbQuery->execute(array("userId" => $userid, "revision" => $number));
} else if (strcasecmp($revision, "reset") == 0) {
    $dbConnection->exec("TRUNCATE TABLE `xmldump`");
} else if ((strcasecmp($revision, "keep") == 0) || (strcasecmp($revision, "k") == 0)) {
    if (empty($number)) {
        header("HTTP/1.0 400 Bad Request");
        exit;
    }

    $dbQuery = $dbConnection->prepare("DELETE FROM `xmldump` WHERE `revision` > :number");
    $dbQuery->execute(array('number' => $number));

    $dbConnection->exec("ALTER TABLE `xmldump` AUTO_INCREMENT = " . (int)(++$number));
    $revision = $number;
}
echo $revision;
