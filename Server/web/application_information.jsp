<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="utf-8"/>
    <meta name="application_information">
    <link rel = "stylesheet" href="./stylesheets/site_styling.css">
    <link rel = "stylesheet" href="./stylesheets/application_information.css">
    <link rel="shortcut icon" type="image/x-icon" href="./images/botornotlogo.png" />
</head>
<title>About Bot-Or-Not</title>
<body>
<ul class="navbar">
    <li><img class = "logo" src = "./images/botornot.png"></li>
    <li><a href = "./application.jsp">Bot-Or-Not</a></li>
    <li><a class="active" href="./application_information.jsp">About Bot-Or-Not</a></li>
    <li><a href = "./survey_page.jsp">Satisfaction Survey</a></li>
    <li><a href = "./twitter_bots.jsp">About Twitter Bots</a></li>
    <li style="float: right"><a href = "./logout.jsp">Logout, <%=request.getParameter("uname")%>?</a></li>
</ul>
<div class="content" style="background-color:white;">
    <h1>About Bot-Or-Not</h1> <hr>
    <h2>What is Bot-Or-Not?</h2>
    <p>
        Bot-Or-Not is a tool to classify a twitter account as a bot or human completed by
        Antonio Segura, Yongqiang Sun, and Jordan Sun. Type the username of a specific twitter username
        into the tool, and we'll let you know if we think the account is real or fake!
    </p>
    <h2>Inspiration Behind Bot-Or-Not</h2>
    <p>
        If you're an avid user of the social media site "Twitter", then chances are that you've seen fake accounts,
        spam accounts, or have had encounters with accounts that you weren't completely sure were ran by a human.
        This is such a commonplace problem throughout twitter that we decided to make an application to determine
        if the account is genuine or fake. A similar project to the one we have completed is <a href="https://botometer.iuni.iu.edu/">"Botometer"</a> completed by Clayton A Davis, Onur Varol,
        Kaicheng Yang, Emilio Ferrara, Alessandro Flammini, and Filippo Menczer. Much of our research entailed the studying
        of their work and their project.

    </p>
    <h2>How it Works</h2>
    <div>
        <div class="attributes">
            Using Twitter's developer API, we pull the 100 most recent tweets of a user (or less if the user hasn't tweeted 100 tweets).
            Using the tweets, we created a dataset of attributes from twitter accounts that we percieved as most relevant to determining
            if an account is real or not (shown on the right).<br><br>
            Using these attributes, we create ratios of the first 6 values from the list by dividing each value by the number of tweets
            returned from the timeline(in case the account has less than 100 tweets total). Furthermore, we calculate the variance of
            the time between tweets. From this we can determine if there is any regularities in the time between tweets, behaviour that indicates
            a bot account. <br><br>
            From these aggregated values, we then created a classification algorithm in Weka using the Random Forest algorithm. Using this classifier,
            this web application plugs in the aggregated values from the timeline of the user inputed and determines the probability that the account
            is real or fake. This project acted as sort of an experiment into how well we could get the algorithm to perform with a limited number of
            attributes only pulled using the timeline API call, and does not include any details regarding the contents of the actual tweets. Therefore,
            as we don't have as many attributes as other research endeavors into bot detection, but our algorithm still performs well given its limited features.
            We also analyzed the performance of various other classification algorithms and determined their quality of performance.
            The performance of the various algorithms tested is shown below, based on a classifier made from 4410 instances.
        </div>
        <br><br>
        <ul class="attributes">
            <li>Number of Retweets</li>
            <li>Number of Hashtags</li>
            <li>Number of URLS</li>
            <li>Number of Quoted Tweets</li>
            <li>Number of Favorites per Tweet</li>
            <li>Number of Retweets per Tweet</li>
            <li>Number of Followers</li>
            <li>Number of Friends</li>
            <li>Count of Listed Users</li>
            <li>Verified Status</li>
            <li>Geo-enabled Status</li>
            <li>If Profile Uses Background Image</li>
            <li>Total Number of Favorites</li>
            <li>Time between tweets</li>
        </ul>
    </div>
    <div style="text-align:center;">
        <table>
            <tr>
                <th>Algorithm</th>
                <th>Human+</th>
                <th>Human-</th>
                <th>Bot+</th>
                <th>Bot-</th>
            </tr>
            <tr>
                <td>Naive Bayes</td>
                <td>1715</td>
                <td>305</td>
                <td>1409</td>
                <td>981</td>
            </tr>
            <tr>
                <td>J48</td>
                <td>2152</td>
                <td>579</td>
                <td>1135</td>
                <td>544</td>
            </tr>
            <tr>
                <td>Random Tree</td>
                <td>2054</td>
                <td>676</td>
                <td>1038</td>
                <td>642</td>
            </tr>
            <tr>
                <td>Random Forest</td>
                <td>2319</td>
                <td>551</td>
                <td>1163</td>
                <td>377</td>
            </tr>
            <tr>
                <td>LMT</td>
                <td>2301</td>
                <td>604</td>
                <td>1110</td>
                <td>395</td>
            </tr>
        </table>
        <h3> Confusion Matrix Results Per Algorithm (+/- denote correct/incorrect classification)</h3>
        <table>
            <tr>
                <th>Algorithm</th>
                <th>Precision</th>
                <th>Recall</th>
                <th>Correctly Classified %</th>
            </tr>
            <tr>
                <td>Naive Bayes</td>
                <td>0.748</td>
                <td>0.708</td>
                <td>70.839</td>
            </tr>
            <tr>
                <td>J48</td>
                <td>0.744</td>
                <td>0.745</td>
                <td>74.5351</td>
            </tr>
            <tr>
                <td>Random Tree</td>
                <td>0.7</td>
                <td>0.701</td>
                <td>70.1134</td>
            </tr>
            <tr>
                <td>Random Forest</td>
                <td>0.787</td>
                <td>0.79</td>
                <td>78.9569</td>
            </tr>
            <tr>
                <td>LMT</td>
                <td>0.771</td>
                <td>0.773</td>
                <td>77.3469</td>
            </tr>
        </table>
        <h3> Precision, Recall, and Percentage of Correctly Classified Instances</h3>
    </div>
</div>
<div class="footer">
    <p>Created by Antonio Segura and Jordan Yono</p>
</div>
</body>
</html>