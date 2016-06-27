package com.karson.portfolio.adnfeed.model;

/**
 * Created by smuthuvijayan on 6/24/16.
 */

/**
 * A strip down version of AppNetData class with only the fields needed to display the post in the UI
 * and an ID for tracking purposes
 */
public class AppNetRowData {
    String id;
    String username;
    String postText;
    String avatarUrl;
    String timeStamp;

    public AppNetRowData(String id, String username, String postText, String avatarUrl, String timeStamp) {
        this.id = id;
        this.username = username;
        this.postText = postText;
        this.avatarUrl = avatarUrl;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
