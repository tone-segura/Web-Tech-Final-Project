package Helpers.Twitter;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class TimelineAttributesModel {
    @SerializedName("id")
    long id;

    public UserObject getUserObject() {
        return UserObject;
    }

    @SerializedName("user")
    UserObject UserObject;
//    int numTweets;
//    int listedCount;
//    int favouritesCount;
//    float retweetRatio, hashtagRatio, quoteRatio, tweetFavoriteRatio, tweetRetweetRatio, mentionRatio, friendFollowerRatio, urlRatio;
    String verified, geoEnabled, protectedUser, profileUsesBackgroundImage, tweetFrequencyVariance, isBot;

    public TimelineAttributesModel[] getTimelineAttributesObject(String twitterTimeline) {
        Gson gson = new Gson();

        TimelineAttributesModel[] tamArray = gson.fromJson(twitterTimeline, TimelineAttributesModel[].class);
        return  tamArray;
    }

    public long getId() {
        return id;
    }

    public static class UserObject{
        @SerializedName("id")
        long userId;
        @SerializedName("friend_count")
        String friendCount;
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
        @SerializedName("favourites_count")
        String favouritesCount;

        public long getUserId() {
            return userId;
        }

        public String getFriendCount() {
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

        public String getFavouritesCount() {
            return favouritesCount;
        }
    }
}