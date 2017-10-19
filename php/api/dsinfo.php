<?php
require_once(dirname(__FILE__) . '/../Config.php');

$id = 0;
$req = $_GET["req"] ?? null;
$name = $_GET["name"] ?? null;
$userid = $_GET["user"] ?? null;
$maxid = $_GET["maxid"] ?? null;
$rev = $_GET["rev"] ?? null;

$dbConnection = Database::getConnection();

if (isset($req)) {
    if ((strcasecmp($req, "get") == 0) || (strcasecmp($rev, "g") == 0)) {
        if (empty($userid) || empty($name)) {
            header("HTTP/1.0 400 Bad Request");
            exit;
        }

        $dbQuery = $dbConnection->prepare(
            "INSERT INTO `data_sources` (`name`, `time_stamp`, `user_id`) VALUES(:name, NOW(), :userId)");
        $dbQuery->execute(array("name" => $name, "userId" => $userid));
        $id = $dbConnection->lastInsertId();
    } else if (((strcasecmp($req, "keep") == 0) || (strcasecmp($req, "k") == 0))) {
        if (empty($maxid)) {
            header("HTTP/1.0 400 Bad Request");
            exit;
        }

        $dbConnection->beginTransaction();
        $dbQuery = $dbConnection->prepare("DELETE FROM `data_sources` WHERE `id` > :maxId");
        $dbQuery->execute(array("maxId" => $maxid));
        $dbQuery = $dbConnection->prepare("ALTER TABLE `data_sources` AUTO_INCREMENT = ".(int)(++$maxid));
        $dbQuery->execute();
        $dbConnection->commit();
        $id = $maxid;
    }
}
echo $id;
