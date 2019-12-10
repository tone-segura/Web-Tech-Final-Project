<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang = "en">
<head>
    <meta charset="utf-8"/>
    <meta name="application">
    <link rel = "stylesheet" href="./stylesheets/site_styling.css">
    <link rel = "stylesheet" href="./stylesheets/application.css">
    <link rel = "stylesheet" href="./stylesheets/input_form.css">
    <link rel="shortcut icon" type="image/x-icon" href="./images/botornotlogo.png" />
</head>
<title>Bot-Or-Not</title>
<body>
<ul class="navbar">
    <li><img class = "logo" src = "./images/botornot.png"></li>
    <li><a class="active" href = "./html_docs/application.html">Bot-Or-Not</a></li>
    <li><a href="./html_docs/application_information.html">About Bot-Or-Not</a></li>
    <li><a href = "./html_docs/survey_page.html">Satisfaction Survey</a></li>
    <li><a href = "./html_docs/twitter_bots.html">About Twitter Bots</a></li>
    <li style="float: right"><a href = "../php_scripts/logout.php">Logout</a></li>
</ul>
<h1> Bot-Or-Not: A Tool to Unmask Twitter Bots</h1>
<div class = "content">
    <div class="centered">
        <div class = "explanation">
            <p>Type the screen name (or "@") into the box below. We'll let you know if we think the account is a bot or human and let you know how certain we are!</p>
        </div>
        <div>
            <form method="Post" action="MyServlet">
            <input type="text" placeholder="@ScreenName" name="uname" required style="float:left; width:82%;">
            <button type="submit" style="vertical-align: middle;display: inline;">Submit</button>
        </form>
        </div>
    </div>
</div>
<div class="footer">
    <p>Created by Antonio Segura and Jordan Yono</p>
</div>
</body>
</html>