import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import com.dbconnection.Dbconnection;
public class CreateUser extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        String tableName = "user_info";

        String f=request.getParameter("fname");
        String l=request.getParameter("lname");
        String e=request.getParameter("email");
        String u=request.getParameter("uname");
        String p=request.getParameter("psw");

        //not quite sure if this will work with the "password()"
        String insertForm = "INSERT INTO " + tableName +
                            " (username, first_name, last_name, email, password)" +
                            " VALUES (" + f +", " + l + ", " + e + ", " + "," + p + "));";

       try {
           Connection con = Dbconnection.initializeDatabase();
           Statement stmt = con.createStatement();
           stmt.executeUpdate(insertForm);
           response.sendRedirect(request.getContextPath()+ "/index.jsp");
           con.close();
       } catch (Exception ex) {
           ex.printStackTrace();
           System.err.println(ex.getMessage());
           response.sendRedirect(request.getContextPath()+ "/register.jsp");
       }

    }
}