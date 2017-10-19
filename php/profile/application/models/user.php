<?php

class user extends model
{
    function update($userId, $options)
    {
        $dbConnection = Database::getConnection();
        $dbQuery = $dbConnection->prepare("UPDATE `users` SET `options` = :options WHERE `id` = :userId");
        $dbQuery->execute(array('options' => $options, 'userId' => $userId));
        return $dbQuery->rowCount();
    }

    function find_by_id($userId)
    {
        $dbConnection = Database::getConnection();
        $dbQuery = $dbConnection->prepare("SELECT `id`, `options` FROM `users` WHERE id = :userId LIMIT 1");
        $dbQuery->execute(array("userId" => (int)$userId));
        return $dbQuery->fetch(PDO::FETCH_ASSOC);
    }
}
