import Helpers.Encryption;
import Helpers.DatabaseConnection;
import Helpers.Twitter.TimelineAttributesHandler;
import Helpers.Twitter.TimelineAttributesModel;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static Helpers.Twitter.TimelineAttributesModel.getTimelineAttributesObject;


public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        String screenName = request.getParameter("uname");

        try {
            // reach out to the twitter api
            String userTimeline = TimelineAttributesHandler.getUserTimeline(screenName);

            // pass the JSON to the timeline model to set values for the entire array mapped to our models
            TimelineAttributesModel[] tams = getTimelineAttributesObject(userTimeline);
            int hashtagCount = 0, userMentionsCount = 0,
                    urlCount = 0, retweetCount = 0, quoteCount = 0,
                    numFavorites = 0, numRetweets = 0;

            long[] varianceList = new long [tams.length];

            for (int i = 0; i < tams.length; i++) {
                // instantiate our object
                TimelineAttributesModel timelineAttributesModel = tams[i];

                numFavorites += tams[i].getFavoriteCount();
                numRetweets += tams[i].getRetweetCount();
                hashtagCount += tams[i].getEntities().getHastags().length;
                userMentionsCount += tams[i].getEntities().getUserMentions().length;
                urlCount += tams[i].getEntities().getUserMentions().length;
                if (tams[i].getText().contains("^RT")) {
                    retweetCount++;
                }
                if (tams[i].isQuoteStatus()) {
                    quoteCount++;
                }
                // try to find a pattern between variance in time of tweets
                if (i > 0 && (i + 1 < tams.length)) {
                    //convert to unix timestamp because twitter format is awful
                    DateFormat formatter = new SimpleDateFormat("EEE MMM d kk:mm:ss Z yyyy");

                    // the data is ordered by created_at DESC, so prev is +1
                    Date curDate = (Date) formatter.parse(tams[i].getCreatedAt());
                    Date prevDate = (Date) formatter.parse(tams[i + 1].getCreatedAt());
                    Date nextDate = (Date) formatter.parse(tams[i - 1].getCreatedAt());

                    long currentTime = curDate.getTime();
                    long prevTime = prevDate.getTime();
                    long nextTime = nextDate.getTime();

                    // picks the smaller time gap to loop for consistent short bursts of tweets and excludes larger jumps as outliers, should pull bots out better
                    // ... i thought this one was crafty
                    varianceList[i] = Math.min(currentTime - prevTime, nextTime - currentTime);
                }

            }

            // Initialize a db connection
            Connection con = DatabaseConnection.initializeDatabase();

            // Use a prepared statement to avoid sql injection and encrypt the password.
            String hashedPassword = Encryption.encryptPassword("password");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user_accounts WHERE username =? AND password =? LIMIT 1;");

            // Set the query param values
            stmt.setString(1, "username");
            stmt.setString(2, hashedPassword);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getLong("user_id"));
            }
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
            System.out.println(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
            // compare user to
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
