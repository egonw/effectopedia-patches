<?php

if (!defined("ENVIRONMENT")) {
    define("ENVIRONMENT", "production");
}

class Database
{
    public static function getConnection()
    {
        $config = new Config();
        /** @var DatabaseConfig $databaseConfig */
        $databaseConfig = $config->databases[ENVIRONMENT] ?? null;
        if (!$databaseConfig) {
            error_log("Cannot find database config for environment: " . ENVIRONMENT);
            header("HTTP/1.0 404 Not Found");
            exit;
        }

        $dbConnection = new PDO(
            $databaseConfig->toPDOConnectionString(),
            $databaseConfig->username,
            $databaseConfig->password, array(
            PDO::MYSQL_ATTR_INIT_COMMAND => "SET time_zone='+00:00';" // Normalize all timestamp input/output to UTC
        ));
        $dbConnection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $dbConnection;
    }
}

class DatabaseConfig
{
    public $host;
    public $port;
    public $username;
    public $password;
    public $name;

    public function __construct($host, $port, $username, $password, $name)
    {
        $this->host = $host;
        $this->port = $port ?? 3306;
        $this->username = $username;
        $this->password = $password;
        $this->name = $name;
    }

    public function toPDOConnectionString() {
        return "mysql:host={$this->host};port={$this->port};dbname={$this->name};charset=utf8mb4";
    }
}
