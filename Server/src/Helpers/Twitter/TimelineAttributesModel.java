package Helpers.Twitter;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class TimelineAttributesModel {
    long userId;
    int numTweets, listedCount, favouritesCount;
    float retweetRatio, hashtagRatio, quoteRatio, tweetFavoriteRatio, tweetRetweetRatio, mentionRatio, friendFollowerRatio, urlRatio;
    String verified, geoEnabled, protectedUser, profileUsesBackgroundImage, tweetFrequencyVariance, isBot;

    public TimelineAttributesModel[] getTimelineAttributesObject(String twitterTimeline) {
        Gson gson = new Gson();

        TimelineAttributesModel[] tamArray = gson.fromJson(twitterTimeline, TimelineAttributesModel[].class);
        return  tamArray;
    }

    @SerializedName("id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getNumTweets() {
        return numTweets;
    }

    public void setNumTweets(int numTweets) {
        this.numTweets = numTweets;
    }

    public int getListedCount() {
        return listedCount;
    }

    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public float getRetweetRatio() {
        return retweetRatio;
    }

    public void setRetweetRatio(float retweetRatio) {
        this.retweetRatio = retweetRatio;
    }

    public float getHashtagRatio() {
        return hashtagRatio;
    }

    public void setHashtagRatio(float hashtagRatio) {
        this.hashtagRatio = hashtagRatio;
    }

    public float getQuoteRatio() {
        return quoteRatio;
    }

    public void setQuoteRatio(float quoteRatio) {
        this.quoteRatio = quoteRatio;
    }

    public float getTweetFavoriteRatio() {
        return tweetFavoriteRatio;
    }

    public void setTweetFavoriteRatio(float tweetFavoriteRatio) {
        this.tweetFavoriteRatio = tweetFavoriteRatio;
    }

    public float getTweetRetweetRatio() {
        return tweetRetweetRatio;
    }

    public void setTweetRetweetRatio(float tweetRetweetRatio) {
        this.tweetRetweetRatio = tweetRetweetRatio;
    }

    public float getMentionRatio() {
        return mentionRatio;
    }

    public void setMentionRatio(float mentionRatio) {
        this.mentionRatio = mentionRatio;
    }

    public float getFriendFollowerRatio() {
        return friendFollowerRatio;
    }

    public void setFriendFollowerRatio(float friendFollowerRatio) {
        this.friendFollowerRatio = friendFollowerRatio;
    }

    public float getUrlRatio() {
        return urlRatio;
    }

    public void setUrlRatio(float urlRatio) {
        this.urlRatio = urlRatio;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(String geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public String getProtectedUser() {
        return protectedUser;
    }

    public void setProtectedUser(String protectedUser) {
        this.protectedUser = protectedUser;
    }

    public String getProfileUsesBackgroundImage() {
        return profileUsesBackgroundImage;
    }

    public void setProfileUsesBackgroundImage(String profileUsesBackgroundImage) {
        this.profileUsesBackgroundImage = profileUsesBackgroundImage;
    }

    public String getTweetFrequencyVariance() {
        return tweetFrequencyVariance;
    }

    public void setTweetFrequencyVariance(String tweetFrequencyVariance) {
        this.tweetFrequencyVariance = tweetFrequencyVariance;
    }

    public String getIsBot() {
        return isBot;
    }

    public void setIsBot(String isBot) {
        this.isBot = isBot;
    }
}
