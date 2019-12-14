import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helpers.Encryption;
import Helpers.DatabaseConnection;

public class Authenticate extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("uname");
            String password = request.getParameter("pswd");

            // Initialize a db connection
            Connection con = DatabaseConnection.initializeDatabase();

            // Use a prepared statement to avoid sql injection and encrypt the password.
            String hashedPassword = Encryption.encryptPassword(password);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user_accounts WHERE username =? AND password =? LIMIT 1;");

            // Set the query param values
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);

            ResultSet resultSet = stmt.executeQuery();

            // Route the response accordingly
            if (resultSet.next()) {
                Cookie user = new Cookie("uname", username);
                response.addCookie(user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/application.jsp");
                requestDispatcher.include(request, response);
            } else {
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