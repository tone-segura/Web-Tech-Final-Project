import com.mysql.cj.xdevapi.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.sql.*;

public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String screenName = request.getParameter("uname");

        // connect to twitter
        // todo need to handle the exception of a private account or an account that doesn't exists
        URLConnection connection = new URL("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+screenName).openConnection();
        connection.setRequestProperty("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAPB9AwEAAAAAw6tsoRJ6PYu0TXohrlNZFMev1H0%3DFKVNVdLEf3QogWdxGjJ96OEFEFYAu1qUbRowcHIuMZjnU7GjZ4");
        InputStream twitterResponse = connection.getInputStream();

        try (PrintWriter writer = response.getWriter()) {
            try (Scanner scanner = new Scanner(twitterResponse)) {
                String responseBody = scanner.useDelimiter("\\A").next();
                writer.println(responseBody);
            }
        }

        // connect to database
        // todo need to write the user info to the database like how we wrote the data in python
        String url = "jdbc:mysql://bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com:3306/bot_or_not";
        String dbUser = "admin";
        String password = "webtechclass";

        System.out.println("Connecting database...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html#establishing_connections
            //1 establish connection
            Connection dbConnection = DriverManager.getConnection(url, dbUser, password);
            System.out.println("Database connected!");
            //2 create a statement
            String query = dbConnection.nativeSQL("SELECT * FROM user_attributes LIMIT 5;");
            Statement statement = dbConnection
                    .createStatement();
            //3 execute statement
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println(resultSet.getLong("user_id"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        // compare user to
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>MyServlet.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>This is a simple java servlet.</h1>");

            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
