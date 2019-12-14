import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.Dbconnection;

public class Authenticate extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("uname");
            String password = request.getParameter("pswd");

            // SHA-512 hash the password
                // From https://www.geeksforgeeks.org/sha-512-hash-in-java/
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hashText = new StringBuilder(no.toString(16));

                // Add preceding 0s to make it 32 bit
            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }
            String hashedPassword = hashText.toString();

            // Initialize a db connection
            Connection con = Dbconnection.initializeDatabase();
            System.out.println("database connected");

            // Use a prepared statement to avoid sql injection.
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user_accounts WHERE username =? AND password =? LIMIT 1;");
            // Set the query param values
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);

            ResultSet resultSet = stmt.executeQuery();

            // Route the response accordingly
            if (resultSet.next()) {
                // If the user exists, enter the application with a cookie
                Cookie user = new Cookie("uname", username);
                response.addCookie(user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/application.jsp");
                requestDispatcher.include(request, response);
            } else {
                // Else, prompted to retry or sign up
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
                requestDispatcher.include(request, response);

                out.print("<p align='center'>Username/Password Combination Not found. " +
                        "<br/> Please Try Again or Sign Up");
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}