import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import com.dbconnection.Dbconnection;
public class SurveyResults extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        String tableName = "survey_results";

        String u=request.getParameter("uname");
        String a=request.getParameter("accuracy");
        String ret=request.getParameter("return");
        String r=request.getParameter("recommend");
        String i=request.getParameter("improve");
        String f=request.getParameter("functional");



        //not quite sure if this will work with the "password()"
        String insertForm = "INSERT INTO " + tableName +
                " (username_value, accuracy_value, return_value, recommend_value, improve_value, functional_value)" +
                " VALUES (" + u +", " + a + ", " + ret + ", " + r + ", " + i + ", " + f+ ");";

        try {
            Connection con = Dbconnection.initializeDatabase();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(insertForm);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
        response.sendRedirect(request.getContextPath()+ "/application.jsp");
    }
}