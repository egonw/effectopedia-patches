<?php
if (!defined("ENVIRONMENT")) {
    header("HTTP/1.0 500 Internal Server Error");
    die("Environment is not defined.");
}

if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    header("HTTP/1.0 405 Requested Method Not Allowed");
    exit;
}

$default_path = dirname(__FILE__) . "/../rev/" . ENVIRONMENT . '/';

$path = $_POST["path"];
$file = $default_path . "upload_log.txt";
$fh = fopen($file, 'w') or die("can't open file");
fwrite($fh, "File upload log.\n");

$allowedExts = array("aop", "aopz", "zip", "xml");
echo "File uploaded to " . $path;
var_dump($_FILES);
fwrite($fh, $_FILES["file"]["type"] . "\n");

$extension = end(explode(".", $_FILES["file"]["name"]));
if ((($_FILES["file"]["type"] == "application/octet-stream") ||
        ($_FILES["file"]["type"] == "application/x-zip-compressed"))
    && ($_FILES["file"]["size"] < 5000000)
    && in_array($extension, $allowedExts)
) {
    if ($_FILES["file"]["error"] > 0) {
        echo "Return Code: " . $_FILES["file"]["error"] . "<br />";
        fwrite($fh, "Return Code: " . $_FILES["file"]["error"] . "\n");

    } else {
        echo "Upload: " . $_FILES["file"]["name"] . "<br />";
        echo "Type: " . $_FILES["file"]["type"] . "<br />";
        echo "Size: " . ($_FILES["file"]["size"] / 1024) . " Kb<br />";
        echo "Temp file: " . $_FILES["file"]["tmp_name"] . "<br />";

        fwrite($fh, "Upload: " . $_FILES["file"]["name"] . "\n");
        fwrite($fh, "Type: " . $_FILES["file"]["type"] . "\n");
        fwrite($fh, "Size: " . ($_FILES["file"]["size"] / 1024) . " Kb\n");
        fwrite($fh, "Temp file: " . $_FILES["file"]["tmp_name"] . "\n");


        if (file_exists($default_path . $_FILES["file"]["name"])) {
            echo $_FILES["file"]["name"] . " already exists. ";
            fwrite($fh, $_FILES["file"]["name"] . " already exists. ");
        } else {
            if (is_dir($default_path . $path))
                $default_path .= $path;
            move_uploaded_file($_FILES["file"]["tmp_name"], $default_path . $_FILES["file"]["name"]);
            echo "\n" . $_FILES["file"]["name"] . " successfully published. ";
            fwrite($fh, "\n" . $_FILES["file"]["name"] . " successfully published. ");
        }
    }
} else {
    echo "Return Code:Invalid File";
    fwrite($fh, "Return Code:Invalid File");
}

fclose($fh);
