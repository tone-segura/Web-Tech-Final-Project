import Helpers.DatabaseConnection;
import weka.classifiers.*;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// TODO
// THIS FILE IS A WIP OF HOW WE WILL CONNECT TO WEKA
// WRITE QUERY TO CSV (FIGURE OUT HOW TO DO STREAM READER IN THE FUTURE)
// PULL CSV INTO WEKA
// TRAIN
// TEST
// PUBLISH RESULTS
public class Weka {
    public static void classify(long userId) {
        System.out.println(userId);

        try {
            // Initialize a db connection
            Connection con = DatabaseConnection.initializeDatabase();

            String trainFile = "./train.csv";
            String testFile = "./test.csv";

            FileWriter fwTrain = new FileWriter(trainFile);
            FileWriter fwTest = new FileWriter(testFile);

            //train
            PreparedStatement trainstmt = con.prepareStatement("SELECT * FROM user_attributes");
            ResultSet trainResult = trainstmt.executeQuery();
            //test
            PreparedStatement teststmt = con.prepareStatement("SELECT * FROM user_attributes WHERE user_id = ? LIMIT 1;");
            teststmt.setLong(1, userId);
            ResultSet testResult = teststmt.executeQuery();
//
//
//            Instances train = new Instances();
//            Instances test = new Instances();
//
//            // Route the response accordingly
////                Instances train = new Instances();
////                Instances test = new Instances();
//            Classifier cls = new J48();
//            cls.buildClassifier(train);
//
//            // evaluate classifier and print some statistics
//            Evaluation eval = new Evaluation(train);
//            eval.evaluateModel(cls, test);

//            System.out.println(eval);
//            System.out.println(eval.correct());
//            System.out.println(eval.incorrect());
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
