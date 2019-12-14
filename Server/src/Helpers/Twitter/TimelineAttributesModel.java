package Helpers.Twitter;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TimelineAttributesModel {

    @SerializedName("id")
    long id;
    @SerializedName("user")
    UserObject UserObject;
    @SerializedName("favorite_count")
    int favoriteCount;
    @SerializedName("retweet_count")
    int retweetCount;
    @SerializedName("text")
    String text;
    @SerializedName("is_quote_status")
    boolean isQuoteStatus;
    @SerializedName("created_at")
    String createdAt;
    @SerializedName("entities")
    Entities entities;

    public static TimelineAttributesModel[] getTimelineAttributesObject(String twitterTimeline) {
        Gson gson = new Gson();
        return gson.fromJson(twitterTimeline, TimelineAttributesModel[].class);
    }

    public long getId() {
        return id;
    }

    public UserObject getUserObject() {
        return UserObject;
    }

    public int getFavoriteCount() {
        return favoriteCount;

    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public String getText() {
        return text;
    }

    public boolean isQuoteStatus() {
        return isQuoteStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Entities getEntities() {
        return entities;
    }

    // nested user object
    public static class UserObject {
        @SerializedName("id")
        long userId;
        @SerializedName("friend_count")
        int friendCount;
        @SerializedName("followers_count")
        String followersCount;
        @SerializedName("listed_count")
        String listedCount;
        @SerializedName("verified")
        String verified;
        @SerializedName("geo_enabled")
        String geoEnabled;
        @SerializedName("protected")
        String protectedUser;
        @SerializedName("profile_use_background_image")
        String profileUseBackgroundImage;

        public long getUserId() {
            return userId;
        }

        public int getFriendCount() {
            return friendCount;
        }

        public String getFollowersCount() {
            return followersCount;
        }

        public String getListedCount() {
            return listedCount;
        }

        public String getVerified() {
            return verified;
        }

        public String getGeoEnabled() {
            return geoEnabled;
        }

        public String getProtectedUser() {
            return protectedUser;
        }

        public String getProfileUseBackgroundImage() {
            return profileUseBackgroundImage;
        }

    }

    // nested entities object
    public static class Entities {
        @SerializedName("hastags")
        Object[] hastags;
        @SerializedName("user_mentions")
        Object[] userMentions;
        @SerializedName("urls")
        Object[] urls;

        public Object[] getHastags() {
            return hastags;
        }

        public Object[] getUserMentions() {
            return userMentions;
        }
        // there's some inconsistency in the twitter api with these. it might also be url{url[url{}]}? in the json
        public Object[] getUrls() {
            return urls;
        }
    }

    public static class DatabaseAttributesModel {

    }
}