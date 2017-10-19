<?php

class users extends controller
{
    function index()
    {
        $this->redirect("users/profile_update");
    }

    function profile_update()
    {
        if (!isset($_SESSION["user"])) {
            header("HTTP/1.0 401 Unauthorized");
            exit;
        }

        $config = new Config();
        $viewData = array();

        // load user model
        $user = $this->loadModel("user");

        // complete registration form submitted?
        if ($_SERVER["REQUEST_METHOD"] === "POST") {
            $changes_ntf = 0;
            if (isset($_POST["notify_on_changes"])) {
                $changes_ntf = (int)$_POST["notify_on_changes"];
            }
            $discuss_ntf = 0;
            if (isset($_POST["notify_on_discussions"])) {
                $discuss_ntf = (int)$_POST["notify_on_discussions"];
            }
            $options = $changes_ntf | $discuss_ntf;

            // update user profile
            $user->update($_SESSION["user"], $options);

            $this->redirect("users/profile_update&updated=1");
        }

        // get the user data from database
        $user_data = $user->find_by_id($_SESSION["user"]);
        if (!$user_data) {
            header("HTTP/1.0 403 Forbidden");
            exit;
        }

        // load profile view
        $viewData["user_data"] = $user_data;
        $viewData["account_url"] = $config->account_url;
        $viewData["updated"] = ($_GET['updated'] ?? false) === "1";
        $viewData["form_action"] = "http" . (($_SERVER['HTTPS'] == "on") ? "s://" : "://") . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];

        $this->loadView("users/profile_update", $viewData);
    }
}
