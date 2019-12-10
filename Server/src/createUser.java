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
        String url = "jdbc:mariadb://bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com:3306/bot-or-not";
        String dbUser = "admin";
        String password = "webtechclass";
        String tableName = "user_info";

        PrintWriter out = response.getWriter();   
        String f=request.getParameter("fname");  
        String l=request.getParameter("lname");  
        String e=request.getParameter("email");  
        String u=request.getParameter("uname");  
        String p=request.getParameter("psw");

        //not quite sure if this will work with the "password()" 
        String insertForm = "INSERT INTO " + tableName + 
                            " (user_id, first_name, last_name, email, password)" +
                            " VALUES (" + f +", " + l + ", " + e + ", " + u + ", PASSWORD(" + p + "));"

        try (Connection dbConnection = DriverManager.getConnection(url, dbUser, password)) {
            System.out.println("Database connected!");
            dbConnection.nativeSQL(insertForm);
        } catch (SQLException e) {
            System.out.print(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
        }     
    }   
}  