import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.Cookie;

import com.dbconnection.Dbconnection;

public class Authenticate extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String tableName = "user_info";
        try {
            String username = request.getParameter("uname");
            String password = request.getParameter("pswd");
            String query = "select * from user_info where username =" + username + " and password = " + password;
            Connection con = Dbconnection.initializeDatabase();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next() == false){
                request.getRequestDispatcher(request.getContextPath()+ "/index.jsp").include(request, response);
                out.print("<p align='center'>User Does Not Exist! Please Register");
                response.sendRedirect(request.getContextPath()+ "/index.jsp");
            }
            else {
                Cookie user = new Cookie("uname", username);
                response.addCookie(user);
                response.sendRedirect(request.getContextPath()+ "/application.jsp");
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        //

    }
}