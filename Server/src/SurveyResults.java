import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import Helpers.DatabaseConnection;
import Helpers.Encryption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

public class SurveyResults extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("uname");
        String accuracy = request.getParameter("accuracy");
        String returnValue = request.getParameter("return");
        String recommendValue = request.getParameter("recommend");
        String improveValue = request.getParameter("improve");
        String functionalValue = request.getParameter("functional");

        try {
            // Initialize a db connection
            Connection con = DatabaseConnection.initializeDatabase();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO survey_results (username_value, accuracy_value, return_value, recommend_value, improve_value, functional_value) VALUES (?,?,?,?,?,?)");

            // Set the query param values
            stmt.setString(1, userName);
            stmt.setString(2, accuracy);
            stmt.setString(3, returnValue);
            stmt.setString(4, recommendValue);
            stmt.setString(5, improveValue);
            stmt.setString(6, functionalValue);

            stmt.execute();

            con.close();
            response.sendRedirect(request.getContextPath() + "/survey_page.jsp");
        } catch (SQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());

            PrintWriter out = response.getWriter();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/survey_page.jsp");
            requestDispatcher.include(request, response);

            out.print("<p align='center' > Uh Oh, looks like there was an issue.</p>");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            response.sendRedirect(request.getContextPath() + "/survey_page.jsp.");
        }

    }
}