package Helpers.Twitter;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class TimelineAttributesHandler {
    public static String getUserTimeline(String screenName) throws IOException {
        // connect to twitter api
        // api tokens
        URLConnection connection = new URL("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=" + screenName).openConnection();
        connection.setRequestProperty("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAPB9AwEAAAAAw6tsoRJ6PYu0TXohrlNZFMev1H0%3DFKVNVdLEf3QogWdxGjJ96OEFEFYAu1qUbRowcHIuMZjnU7GjZ4");
        InputStream twitterResponse = connection.getInputStream();

        // parse response
        try (Scanner scanner = new Scanner(twitterResponse)) {
            System.out.println("grapefruit");

            String obj = scanner.useDelimiter("\\A").next();

            System.out.println(obj);
            return obj;
        }
    }

}

