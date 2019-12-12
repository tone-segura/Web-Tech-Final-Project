import java.sql.*;

public class Main {
    public static void main(String[] args){
        // connect to database
        String url = "jdbc:mysql://bot-or-not.csugsk2tp4ra.us-east-1.rds.amazonaws.com:3306/";
        String dbUser = "admin";
        String password = "webtechclass";

        System.out.println("Connecting database...");
        try {
            Connection dbConnection = DriverManager.getConnection(url, dbUser, password);
            System.out.println("Database connected!");
            dbConnection.nativeSQL("SELECT 1;");
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
