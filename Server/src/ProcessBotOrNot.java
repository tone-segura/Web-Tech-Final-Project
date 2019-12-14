import Helpers.Encryption;
import Helpers.DatabaseConnection;
import Helpers.Twitter.TimelineAttributesHandler;
import Helpers.Twitter.TimelineAttributesModel;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

import static Helpers.Twitter.TimelineAttributesModel.getTimelineAttributesObject;


public class ProcessBotOrNot extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        String screenName = request.getParameter("uname");
        String isBot = request.getParameter("isBot");

        try {
            // reach out to the twitter api
            String userTimeline = TimelineAttributesHandler.getUserTimeline(screenName);

            // pass the JSON to the timeline model to set values for the entire array mapped to our models
            TimelineAttributesModel[] tams = getTimelineAttributesObject(userTimeline);
            float hashtagCount = 0, userMentionsCount = 0,
                    urlCount = 0, retweetCount = 0, quoteCount = 0,
                    numFavorites = 0, numRetweets = 0, tweetCount = 0;

            long[] varianceList = new long[tams.length];

            tweetCount = tams.length;

            for (int i = 0; i < tams.length; i++) {
                numFavorites += tams[i].getFavoriteCount();
                numRetweets += tams[i].getRetweetCount();

                if (tams[i].getEntities() != null) {
                    if (tams[i].getEntities().getHastags() != null && tams[i].getEntities().getHastags().length > 0) {
                        hashtagCount += tams[i].getEntities().getHastags().length;
                    }
                    if (tams[i].getEntities().getUserMentions() != null && tams[i].getEntities().getUserMentions().length > 0) {
                        userMentionsCount += tams[i].getEntities().getUserMentions().length;
                    }
                    if (tams[i].getEntities().getUrls() != null && tams[i].getEntities().getUrls().length > 0) {
                        urlCount += tams[i].getEntities().getUrls().length;
                    }
                }

                if (tams[i].getText().contains("^RT")) {
                    retweetCount++;
                }
                if (tams[i].isQuoteStatus()) {
                    quoteCount++;
                }
                // try to find a pattern between variance in time of tweets
                if (i > 0 && (i + 1 < tams.length)) {
                    //convert to unix timestamp because twitter format is awful

                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d kk:mm:ss Z yyyy");

                        long currentTime = formatter.parse(tams[i].getCreatedAt()).getTime();
                        long prevTime = formatter.parse(tams[i + 1].getCreatedAt()).getTime();
                        long nextTime = formatter.parse(tams[i - 1].getCreatedAt()).getTime();
                        ;

                        // picks the smaller time gap to loop for consistent short bursts of tweets and excludes larger jumps as outliers, should pull bots out better
                        // ... i thought this one was crafty
                        varianceList[i] = Math.min(currentTime - prevTime, nextTime - currentTime);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            // calulate the mean/variance
            double mean = 0.0;
            for (double l : varianceList) {
                mean += l;
            }
            mean /= varianceList.length;
            double variance = 0.0;
            for (long l : varianceList) {
                variance += ((double) l - mean) * (l - mean);
            }

            // Initialize a db connection
            Connection con = DatabaseConnection.initializeDatabase();

            // Use a prepared statement to avoid sql injection
            PreparedStatement stmt = con.prepareStatement("INSERT INTO user_attributes VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            System.out.println(isBot);
            System.out.println(stmt);
            System.out.println(stmt.toString());
            System.out.println(tams[0].getUserObject().getUserId());
            // Set the query param values
            stmt.setLong(1, tams[0].getUserObject().getUserId()); // user_id
            stmt.setInt(2, tams[0].getUserObject().getStatusesCount()); //num_tweets
            stmt.setFloat(3, retweetCount / tweetCount); //retweet_ratio
            stmt.setFloat(4, hashtagCount / tweetCount); // hashtag_ratio
            stmt.setFloat(5, quoteCount / tweetCount); //quote_ratio
            stmt.setFloat(6, numFavorites / tweetCount);
            stmt.setFloat(7, numRetweets / tweetCount);
            stmt.setFloat(8, userMentionsCount / tweetCount);
            stmt.setFloat(9, tams[0].getUserObject().getFriendCount() / tams[0].getUserObject().getFollowersCount());
            stmt.setFloat(10, urlCount / tweetCount);
            stmt.setInt(11, tams[0].getUserObject().getListedCount());
            stmt.setString(12, tams[0].getUserObject().getVerified());
            stmt.setString(13, tams[0].getUserObject().getGeoEnabled());
            stmt.setString(14, tams[0].getUserObject().getProfileUseBackgroundImage());
            stmt.setInt(15, tams[0].getUserObject().getFavoriteCount());
            stmt.setString(16, Double.toString(variance));
            stmt.setString(17, isBot);

            stmt.execute();

            response.sendRedirect(request.getContextPath() + "/index.jsp");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Error connecting the database ", e);
            // compare user to
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
