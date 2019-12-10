import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
    
public class Register extends HttpServlet {  

    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        .withRegion(Regions.US_CENTRAL_1).build();
    static DynamoDB dynamoDB = new DynamoDB(client);
    static String tableName = "user_info";
    Map<String, AttributeValue> attributeValues = new HashMap<>();
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
  
        PrintWriter out = response.getWriter();  
                
        String f=request.getParameter("fname");  
        String l=request.getParameter("lname");  
        String e=request.getParameter("email");  
        String u=request.getParameter("uname");  
        String p=request.getParameter("psw");
        attributeValues.put("first_name",new AttributeValue().withS(f));
        attributeValues.put("last_name",new AttributeValue().withS(l));
        attributeValues.put("email;",new AttributeValue().withS(e));
        attributeValues.put("username",new AttributeValue().withS(u));
        attributeValues.put("password",new AttributeValue().withS(p));
        try{  
            PutItemRequest putItemRequest = new putItemRequest()
                .withTableName(tableName)
                .withItem(attributeValues);
            PutItemResult putItemResult = amazonDynamoDB.putItem(putItemRequest);
        }catch (Exception e2) {System.out.println(e2);}  
                
        out.close();  
    }   
}  