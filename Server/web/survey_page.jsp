
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="utf-8"/>
    <meta name="survey_page">
    <link rel = "stylesheet" href="./stylesheets/site_styling.css">
    <link rel = "stylesheet" href="./stylesheets/survey_page.css">
    <link rel="shortcut icon" type="image/x-icon" href="./images/botornotlogo.png" />
</head>
<title>Bot-Or-Not</title>
<body>
<ul class="navbar">
    <li><img class = "logo" src = "./images/botornot.png"></li>
    <li><a href = "./application.jsp">Bot-Or-Not</a></li>
    <li><a href="./application_information.jsp">About Bot-Or-Not</a></li>
    <li><a class="active" href = "./survey_page.jsp">Satisfaction Survey</a></li>
    <li><a href = "./twitter_bots.jsp">About Twitter Bots</a></li>
    <li style="float: right"><a href = "./logout.jsp">Logout, <%=request.getParameter("uname")%>?</a></li>
    </form>
</ul>
<div class="content" style="background-color:white;">
    <h1>How Well Did Bot-Or-Not Work?</h1> <hr>

    <h2>Was the result accurate?</h2>

    <form method="POST" action = "SurveyResults">
        <label class="container"> Strongly Disagree
            <input type="radio"  name="accuracy" value="strongly_disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Disagree
            <input type="radio" name="accuracy" value="disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Neutral
            <input type="radio"  name="accuracy" value="neutral">
            <span class="checkmark"></span>
        </label>
        <label class="container">Agree
            <input type="radio" name="accuracy" value="agree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Strongly Agree
            <input type="radio" name="accuracy" value="strongly_agree">
            <span class="checkmark"></span>
        </label>

        <h2>Will you be using Bot-Or-Not again?</h2>
        <label class="container"> Strongly Disagree
            <input type="radio"  name="return" value="strongly_disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Disagree
            <input type="radio" name="return" value="disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Neutral
            <input type="radio"  name="return" value="neutral">
            <span class="checkmark"></span>
        </label>
        <label class="container">Agree
            <input type="radio" name="return" value="agree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Strongly Agree
            <input type="radio" name="return" value="strongly_agree">
            <span class="checkmark"></span>
        </label>

        <h2>Would you recommend someone else to use Bot-Or-Not?</h2>
        <label class="container"> Strongly Disagree
            <input type="radio"  name="recommend" value="strongly_disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Disagree
            <input type="radio" name="recommend" value="disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Neutral
            <input type="radio"  name="recommend" value="neutral">
            <span class="checkmark"></span>
        </label>
        <label class="container">Agree
            <input type="radio" name="recommend" value="agree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Strongly Agree
            <input type="radio" name="recommend" value="strongly_agree">
            <span class="checkmark"></span>
        </label>

        <h2>Would you return to this website if we improved the tool?</h2>
        <label class="container"> Strongly Disagree
            <input type="radio"  name="improve" value="strongly_disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Disagree
            <input type="radio" name="improve" value="disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Neutral
            <input type="radio"  name="improve" value="neutral">
            <span class="checkmark"></span>
        </label>
        <label class="container">Agree
            <input type="radio" name="improve" value="agree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Strongly Agree
            <input type="radio" name="improve" value="strongly_agree">
            <span class="checkmark"></span>
        </label>

        <h2>Is the website functional?</h2>
        <label class="container"> Strongly Disagree
            <input type="radio"  name="functional" value="strongly_disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Disagree
            <input type="radio" name="functional" value="disagree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Neutral
            <input type="radio"  name="functional" value="neutral">
            <span class="checkmark"></span>
        </label>
        <label class="container">Agree
            <input type="radio" name="functional" value="agree">
            <span class="checkmark"></span>
        </label>
        <label class="container">Strongly Agree
            <input type="radio" name="functional" value="strongly_agree">
            <span class="checkmark"></span>
        </label>
        <button type="submit" style="vertical-align: middle;display: inline;">Submit</button>
    </form>
</div>
<div class="footer">
    <p>Created by Antonio Segura and Jordan Yono</p>
</div>
</body>
</html>
