
package com.example.smuthuvijayan.rxsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */
public class Counts {

    @SerializedName("following")
    @Expose
    private Integer following;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("stars")
    @Expose
    private Integer stars;

    /**
     * No args constructor for use in serialization
     */
    public Counts() {
    }

    /**
     * @param followers
     * @param following
     * @param stars
     * @param posts
     */
    public Counts(Integer following, Integer posts, Integer followers, Integer stars) {
        this.following = following;
        this.posts = posts;
        this.followers = followers;
        this.stars = stars;
    }

    /**
     * @return The following
     */
    public Integer getFollowing() {
        return following;
    }

    /**
     * @param following The following
     */
    public void setFollowing(Integer following) {
        this.following = following;
    }

    /**
     * @return The posts
     */
    public Integer getPosts() {
        return posts;
    }

    /**
     * @param posts The posts
     */
    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    /**
     * @return The followers
     */
    public Integer getFollowers() {
        return followers;
    }

    /**
     * @param followers The followers
     */
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    /**
     * @return The stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * @param stars The stars
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

}
