package com.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    public static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com:3306/bot_or_not";
        String dbUser = "admin";
        String password = "webtechclass";

        System.out.println("Connecting database...");

        //I'm not sure that .cj should be here
        Class.forName("com.cj.mysql.jdbc.Driver");
        // https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html#establishing_connections
        //1 establish connection
        return DriverManager.getConnection(url, dbUser, password);
    }
}
