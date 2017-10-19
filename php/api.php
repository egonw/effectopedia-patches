<?php

$pathInfo = $_SERVER["PATH_INFO"] ?? null;
if (!$pathInfo) {
    header("HTTP/1.0 400 Bad Request");
    exit;
}

$pathInfoParts = explode("/", $pathInfo);
if (count($pathInfoParts) <= 2) {
    header("HTTP/1.0 400 Bad Request");
    exit;
}

if (!$pathInfoParts[0]) {
    array_shift($pathInfoParts);
}
$environment = array_shift($pathInfoParts);
$pathInfo = implode("/", $pathInfoParts);

// Prevent remote file inclusion and parent directory traversal attacks
if (preg_match("/^([A-Za-z_]+(\\.(php|html))?)?$/i", $pathInfo) === 0) {
    header("HTTP/1.0 403 Forbidden");
    echo "Illegal path";
    exit;
}

$apiScript = dirname(__FILE__) . "/api/$pathInfo";
if (!file_exists($apiScript)) {
    header("HTTP/1.0 404 Not Found");
    exit;
}

if (is_dir($apiScript)) {
    if ($apiScript[strlen($apiScript) - 1] !== '/') {
        $apiScript .= '/';
    }
    $apiScript .= 'index.php';
}

if (!file_exists($apiScript)) {
    header("HTTP/1.0 404 Not Found");
    exit;
}

define("ENVIRONMENT", $environment);
require_once($apiScript);
