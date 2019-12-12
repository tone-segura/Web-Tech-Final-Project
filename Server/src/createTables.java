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

public class createTable extends javax.servlet.http.HttpServlet {
    private static final String CSV_FILE_PATH = "weka_data.csv";    
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = "jdbc:mariadb://bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com:3306/bot-or-not";
        String dbUser = "admin";
        String password = "webtechclass";
        

        String createUserTable =   "CREATE TABLE user_info (" +
                                    "user_id MEDIUMINT NOT NULL AUTO_INCREMENT,"+
                                    "first_name CHAR NOT NULL,"+
                                    "last_name CHAR NOT NULL," +
                                    "email CHAR NOT NULL," +
                                    "password CHAR NOT NULL);";
                                    
     

        try (Connection dbConnection = DriverManager.getConnection(url, dbUser, password)) {
            System.out.println("Database connected!");
            dbConnection.nativeSQL(createUserTable);
        } catch (SQLException e) {
            System.out.print(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
        }    
        
        
        
                        
    }
     
   
        
}