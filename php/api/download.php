<?php

if (!defined("ENVIRONMENT")) {
    header("HTTP/1.0 500 Internal Server Error");
    die("Environment is not defined.");
}

if ($_SERVER["REQUEST_METHOD"] !== "GET") {
    header("HTTP/1.0 405 Requested Method Not Allowed");
    exit;
}

$fileName = $_GET['name'] ?? null;
if (!$fileName) {
    header("HTTP/1.0 400 Bad Request");
    exit;
}

// Prevent remote file inclusion and parent directory traversal attacks
if (preg_match("/^([A-Za-z0-9]+(\\.[A-Za-z0-9]+)?)?$/i", $fileName) === 0) {
    header("HTTP/1.0 403 Forbidden");
    echo "Illegal path";
    exit;
}

$path = dirname(__FILE__) . "/../rev/" . ENVIRONMENT . '/' . $fileName;
$realPath = realpath($path);

if (!file_exists($realPath) || is_dir($realPath)) {
    header("HTTP/1.0 404 Not Found");
    exit;
}

header("X-Sendfile: $realPath");
header("Content-Type: application/octet-stream");
header("Content-Disposition: attachment; filename=\"$fileName\"");

