
package com.karson.portfolio.adnfeed.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */
public class Entities {

    @SerializedName("mentions")
    @Expose
    private List<Object> mentions = new ArrayList<Object>();
    @SerializedName("hashtags")
    @Expose
    private List<Object> hashtags = new ArrayList<Object>();
    @SerializedName("links")
    @Expose
    private List<Link> links = new ArrayList<Link>();

    /**
     * No args constructor for use in serialization
     */
    public Entities() {
    }

    /**
     * @param links
     * @param hashtags
     * @param mentions
     */
    public Entities(List<Object> mentions, List<Object> hashtags, List<Link> links) {
        this.mentions = mentions;
        this.hashtags = hashtags;
        this.links = links;
    }

    /**
     * @return The mentions
     */
    public List<Object> getMentions() {
        return mentions;
    }

    /**
     * @param mentions The mentions
     */
    public void setMentions(List<Object> mentions) {
        this.mentions = mentions;
    }

    /**
     * @return The hashtags
     */
    public List<Object> getHashtags() {
        return hashtags;
    }

    /**
     * @param hashtags The hashtags
     */
    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * @return The links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * @param links The links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
