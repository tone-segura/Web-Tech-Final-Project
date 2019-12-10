import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.sql.*;
import com.opencsv.CSVReader;

public class MyServlet extends javax.servlet.http.HttpServlet {
    private static final String CSV_FILE_PATH = "weka_data.csv";    
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = "jdbc:mariadb://bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com:3306/bot-or-not";
        String dbUser = "admin";
        String password = "webtechclass";
        

        String createUserTable =   "CREATE TABLE user_info (
                                    user_id MEDIUMINT NOT NULL AUTO_INCREMENT,
                                    first_name CHAR NOT NULL,
                                    last_name CHAR NOT NULL,
                                    email CHAR NOT NULL,
                                    password CHAR NOT NULL
                                    );";
        String createWekaTable =   "CREATE TABLE weka_data (
                                    user_id LONGINT, num_tweets INT, retweet_ratio FLOAT, 
                                    hashtag_ratio FLOAT, quote_ratio FLOAT, tweet_favorite_ratio FLOAT,
                                    tweet_retweet_ratio FLOAT, mention_ratio FLOAT, 
                                    friend_follower_ratio FLOAT, url_ratio FLOAT, listed_count INT, 
                                    verified STRING, geo_enabled STRING,  
                                    profile_uses_background_image STRING, favourites_count INT,
                                    tweet_frequency_variance FLOAT, class STRING
                                    );";
                                    
        //mariaDB function to load a file, may cause issues
        String loadWekaTable =   "LOAD DATA LOCAL INFILE \'source.csv\' INTO weka_data FIELDS TERMINATED BY \',\' ENCLOSED BY \'\"\' LINES TERMINATED BY \'\\r\\n\';";
        try (Connection dbConnection = DriverManager.getConnection(url, dbUser, password)) {
            System.out.println("Database connected!");
            dbConnection.nativeSQL(createUserTable);
            dbConnection.nativeSQL(createWekaTable);
            dbConnection.nativeSQL(loadWekaTable);
        } catch (SQLException e) {
            System.out.print(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
        }    
        
        
        
                        
    }
     
   
        
}