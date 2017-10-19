<?php
require_once(dirname(__FILE__) . '/../Config.php');

$tID = $_GET["id"] ?? null;
if (!$tID) {
    header("HTTP/1.0 400 Bad Request");
    exit;
}

$dbConnection = Database::getConnection();
$dbQuery = $dbConnection->prepare("SELECT `user_id` FROM `teams` WHERE `id` = :id");
$dbQuery->execute(array("id" => $tID));

$userIds = array();
while ($row = $dbQuery->fetchObject()) {
    $userIds[] = $row->user_id;
}

echo "<!--team_ids";
echo implode(", ", $userIds);
echo "team_ids-->";
