
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="utf-8"/>
    <meta name="twitter_bot_information">
    <link rel = "stylesheet" href="./stylesheets/site_styling.css">
    <link rel = "stylesheet" href="./stylesheets/twitter_bots.css">
    <link rel="shortcut icon" type="image/x-icon" href="./images/botornotlogo.png" />
</head>
<title>About Bot-Or-Not</title>
<body>
<ul class="navbar">
    <li><img class = "logo" src = "./images/botornot.png"></li>
    <li><a href = "./application.jsp">Bot-Or-Not</a></li>
    <li><a  href="./application_information.jsp">About Bot-Or-Not</a></li>
    <li><a href = "./survey_page.jsp">Satisfaction Survey</a></li>
    <li><a class="active" href = "./twitter_bots.jsp">About Twitter Bots</a></li>
    <li style="float: right"><a href = "./logout.jsp">Logout, <%=request.getParameter("uname")%>?</a></li>
</ul>
<div class = "column left">
    <img class = "i" src = "./images/bot-content-amp.svg"
    /><img class = "i" src = "./images/standing-rock-bot.svg"
    /><img class = "i" src = "./images/bot-same-tweets.svg"
    /><img class = "i" src = "./images/impeach-trump-bot.svg">
</div>
<div class = "column middle">
    <h1> What are Twitter Bots?</h1>
    <p>
        Twitter bots are fake accounts or accounts ran by a computer that are
        prevalent throughout Twitter. Twitter has a system in place that allows
        twitter facilitated bots, that use Twitter's api to regularly post tweets.
        Other, more nefarious, bots are very common, but sometimes hard to detect.
        These bot accounts likely use third party software or some manipulation of
        Twitter's api. In general, bot accounts are based on scripts that output tweets
        at a regular basis for some purpose.
    </p>
    <h2> Types of Twitter Bots</h2>
    <ul>
        <li>
            Content Bots (relatively harmless)
        </li>
        These are fairly common, adding to the humor of Twitter or
        act as update feeds for events.
        <li>
            Commercial Bots (add to spam, but don't affect much)
        </li>
        The most common by far. They don't tend to tweet, and
        are more often used to like, retweet, and follow other accounts.
        Some are used to steal other account's high performing
        tweets and repost them, to build up a following to then to be sold or promote something.
        <li>
            Discourse Bots (essentially bots that troll people)
        </li>
        Not as common as they used to be, but still relevant around major
        election periods. These are the most notable, but still rather
        uncommon, bots. These aren't really mainstream but can be found
        in the replies of political tweets or tweets from major events.
    </ul>
    <h2> The Point of Twitter Bots</h2>
    <p>
        Some Twitter bots are lighthearted, outputting a friendly message to<a href = "https://twitter.com/tinycarebot?lang=en"> take a break </a>
        or<a href ="https://twitter.com/flagsmashupbot?lang=en"> make random combinations of flags</a>. These are
        the bots that take advantage of Twitter's bot ecosystem in a positive
        or at least content relevant way. They're accounts that make tweets
        that people enjoy and promote. Other bot accounts are less helpful. Many of
        which are created for the purpose of creating political discourse. Furthermore,
        on Twitter (and on essentially all other forms of social media), old/inactive real accounts and new
        fake accounts are used in order to build up an account's follower count, or to constantly
        retweet that account's tweets. This is usually done for commercial gain, so that a brand
        or person can get more recognition through twitter.
    </p>
    <br>
    <h4 style = "text-align: center">Interface for the Twitter API</h4>
    <br>
    <img class = "i" src ="./images/twitterapi.svg"/>
    <br>
    <br>
</div>
<div class = "column right">
<img class = "i" src = "./images/amazon-bots.svg"
/><img class = "i" src = "./images/spam-bots.svg"
/><img class = "i" src = "./images/trump-rally-bots.svg"
/><img class = "i" src = "./images/sandwich-bot.svg" >
</div>
<div class="footer">
    <p>Created by Antonio Segura and Jordan Yono</p>
</div>
</body>
</html>
