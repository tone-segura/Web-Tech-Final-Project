<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang = "en">
<head>
    <title>Bot-Or-Not</title>
    <meta charset="utf-8"/>
    <meta name="application">
    <link rel = "stylesheet" href="./stylesheets/site_styling.css">
    <link rel = "stylesheet" href="./stylesheets/application.css">
    <link rel = "stylesheet" href="./stylesheets/input_form.css">
    <link rel="shortcut icon" type="image/x-icon" href="./images/botornotlogo.png" />
</head>

<body>
<ul class="navbar">
    <li><img class = "logo" src = "./images/botornot.png" alt ="logo"></li>
    <li><a class="active" href = "./application.jsp">Bot-Or-Not</a></li>
    <li><a href="./application_information.jsp">About Bot-Or-Not</a></li>
    <li><a href = "./survey_page.jsp">Satisfaction Survey</a></li>
    <li><a href = "./twitter_bots.jsp">About Twitter Bots</a></li>
    <li style="float: right"><a href = "./logout.jsp">Logout, <%=request.getParameter("username")%>?</a></li>
</ul>
<h1> Bot-Or-Not: A Tool to Unmask Twitter Bots</h1>
<div class = "content">
    <label class="centered">
        <br><br><br>
        <div class = "explanation">
            <p>Type the screen name (or "@") into the box below and select whether you believe the account is a bot. We'll let you know if we think the account is a bot or human and let you know how certain we are!</p>
        </div>
        <div style = "max-width: 100%; display: flex; align-items: center">
            <form method="Post" action="MyServlet">
                <input type="text" placeholder="@ScreenName" name="uname" required style="float:left; width:80%;">
                <button type="submit" style="vertical-align: middle;display: inline; float: right;">Submit</button>
                <br><br><br>
                <label>
                    Select if the account is a bot<input type = "radio" name ="is_bot" value = "True">
                </label>

            </form>
        </div>
    </div>
</div>
<div class="footer">
    <p>Created by Antonio Segura and Jordan Yono</p>
</div>
</body>
</html>