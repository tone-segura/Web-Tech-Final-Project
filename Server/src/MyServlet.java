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
        String username = request.getParameter("uname");

        // connect to twitter
        URLConnection connection = new URL("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=jordanyonodev").openConnection();
        connection.setRequestProperty("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAPB9AwEAAAAAw6tsoRJ6PYu0TXohrlNZFMev1H0%3DFKVNVdLEf3QogWdxGjJ96OEFEFYAu1qUbRowcHIuMZjnU7GjZ4");
        InputStream twitterResponse = connection.getInputStream();

        try (PrintWriter writer = response.getWriter()) {
            try (Scanner scanner = new Scanner(twitterResponse)) {
                String responseBody = scanner.useDelimiter("\\A").next();
                writer.println(responseBody);
            }
        }

        // connect to database
        String url = "jdbc:mysql://bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com:3306/";
        String dbUser = "admin";
        String password = "webtechclass";

        System.out.println("Connecting database...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, dbUser, password);
            System.out.println("Database connected!");
            dbConnection.nativeSQL("SELECT 1;");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
        }
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
