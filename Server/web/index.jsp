
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="utf-8"/>
    <meta name="survey_page">
    <link rel = "stylesheet" href="./stylesheets/site_styling.css">
    <link rel = "stylesheet" href="./stylesheets/input_form.css">
    <link rel="shortcut icon" type="image/x-icon" href="./images/botornotlogo.png" />
</head>
<title>Bot-Or-Not</title>
<body>
<img class="banner" src = "./images/botornot.png" alt = "Bot Or Not Logo">
<form action="Authenticate" method="post">
    <div class = "centered">
        <div class="container" style="background-color:#f1f1f1; max-width: 400px;">
            <label><b>Username</b>
            <input type="text" placeholder="Enter Username" name="uname" required>
            </label>
            <label><b>Password</b>
            <input type="password" placeholder="Enter Password" name="pswd" required>
            </label>
            <!--for now login button redirects to bot-or-not page-->
            <button type="submit">Login</button>
            <button type="button" class="signupbtn" onclick="window.location.href ='register.jsp';">Sign Up</button>
        </div>
    </div>
</form>
</body>
</html>