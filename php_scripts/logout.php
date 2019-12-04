<?php
session_start();
unset($_SESSION);
session_destroy();
session_write_close();
header('Location: ../html_docs/login_page.html');
die;
?>