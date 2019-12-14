
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
<div class = "centered">
<form action="CreateUser" method="post">
        <div class="container" style="background-color:#f1f1f1; max-width: 400px;">
            <label><b>First Name</b>
                <input type="text" placeholder="Enter Your First Name" name="fname" required>
            </label>
            <label><b>Last Name</b>
                <input type="text" placeholder="Enter Your Last Name" name="lname" required>
            </label>
            <label><b>Email</b>
                <input type="text" placeholder="Enter Your Email" name="email" required>
            </label>

            <label> <b>Username</b>
                <input type="text" placeholder="Enter Username" name="uname" required>
            </label>
            <label><b>Password</b>
                <input type="password" placeholder="Enter Password" name="psw" required>
            </label>
            <div style = "text-align: center;">
                <button type="submit" class="signupbtn" style="display:inline-block">Join Now</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>