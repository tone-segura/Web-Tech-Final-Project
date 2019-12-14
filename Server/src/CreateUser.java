import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import Helpers.Encryption;
import Helpers.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

// Todo a future state here is to automatically log the user in after account creation
public class CreateUser extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("uname");
        // Don't use raw password on insert.
        String password = request.getParameter("psw");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");

        try {
            // Initialize a db connection
            Connection con = DatabaseConnection.initializeDatabase();

            // Use a prepared statement to avoid sql injection and encrypt the password.
            String hashedPassword = Encryption.encryptPassword(password);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO user_accounts VALUES (?,?,?,?,?)");

            // Set the query param values
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            stmt.setString(3, firstName);
            stmt.setString(4, lastName);
            stmt.setString(5, email);

            stmt.execute();

            response.sendRedirect(request.getContextPath() + "/index.jsp");
            con.close();
        } catch (SQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());

            PrintWriter out = response.getWriter();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
            requestDispatcher.include(request, response);

            out.print("<p align='center' > Uh Oh, it looks like that email or username already exists.</p>");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            response.sendRedirect(request.getContextPath() + "/register.jsp");
        }

    }
}