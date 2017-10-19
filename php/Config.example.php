<?php

// Copy this file to Config.php and fill in the variables below
class Config
{
    public $databases;
    public $authentication_url = "";
    public $access_token_url = "";
    public $user_info_url = "";
    public $account_url = "";
    public $end_session_url = "";
    public $users_url = "";
    public $client_id = "";
    public $service_account_username = "";
    public $service_account_password = "";

    public function __construct()
    {
        $this->databases = array(
            "production" => new DatabaseConfig("localhost", 3306, "root", "", "production"),
            "test" => new DatabaseConfig("localhost", 3306, "root", "", "test"),
            "debug" => new DatabaseConfig("localhost", 3306, "root", "", "debug")
        );
    }
}

// Do not change anything below this comment
require_once(dirname(__FILE__).'/Database.php');
date_default_timezone_set("UTC");
