import Helpers.Encryption;
import Helpers.DatabaseConnection;
import Helpers.Twitter.TimelineAttributesHandler;
import Helpers.Twitter.TimelineAttributesModel;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        String screenName = request.getParameter("uname");

        try {
            String userTimeline = TimelineAttributesHandler.getUserTimeline(screenName);

            TimelineAttributesModel timelineAttributesModel = new TimelineAttributesModel();

            System.out.println("watermelon");
            TimelineAttributesModel[] tam = timelineAttributesModel.getTimelineAttributesObject(userTimeline);
            System.out.println();
            for (TimelineAttributesModel model : tam){
                System.out.println(model);
                System.out.println(model.getUserId());
                TimelineAttributesModel.UserObject userObject = new TimelineAttributesModel.UserObject();
                System.out.println(model.getUserObject());
            }
            System.out.println("prayers");
          //  System.out.println(Arrays.toString(timelineAttributesModel.getTimelineAttributesObject(userTimeline.get(0))));

            // Initialize a db connection
            Connection con = DatabaseConnection.initializeDatabase();

            // Use a prepared statement to avoid sql injection and encrypt the password.
            String hashedPassword = Encryption.encryptPassword("password");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user_accounts WHERE username =? AND password =? LIMIT 1;");

            // Set the query param values
            stmt.setString(1, "username");
            stmt.setString(2, hashedPassword);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getLong("user_id"));
            }
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
            System.out.println(e.toString());
            throw new IllegalStateException("Cannot connect the database!", e);
            // compare user to
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
