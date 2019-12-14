package Helpers.Twitter;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

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

    public float getFavoriteCount() {
        return favoriteCount;
    }

    // nested user object
    public static class UserObject {
        @SerializedName("id")
        long userId;
        @SerializedName("friend_count")
        float friendCount;
        @SerializedName("followers_count")
        float followersCount;
        @SerializedName("listed_count")
        int listedCount;
        @SerializedName("verified")
        String verified;
        @SerializedName("geo_enabled")
        String geoEnabled;
        @SerializedName("profile_use_background_image")
        String profileUseBackgroundImage;
        @SerializedName("statuses_count")
        int statusesCount;
        @SerializedName("favourites_count")
        int favoriteCount;

        public long getUserId() {
            return userId;
        }

        public float getFriendCount() {
            return friendCount;
        }

        public float getFollowersCount() {
            return followersCount;
        }

        public int getListedCount() {
            return listedCount;
        }

        public String getVerified() {
            return verified;
        }

        public String getGeoEnabled() {
            return geoEnabled;
        }

        public String getProfileUseBackgroundImage() {
            return profileUseBackgroundImage;
        }

        public int getStatusesCount() {
            return statusesCount;
        }

        public int getFavoriteCount(){
            return favoriteCount;
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
}