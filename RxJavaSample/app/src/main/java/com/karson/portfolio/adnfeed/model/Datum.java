
package com.karson.portfolio.adnfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */
public class Datum {

    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("num_stars")
    @Expose
    private Integer numStars;
    @SerializedName("num_replies")
    @Expose
    private Integer numReplies;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("num_reposts")
    @Expose
    private Integer numReposts;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("canonical_url")
    @Expose
    private String canonicalUrl;
    @SerializedName("entities")
    @Expose
    private Entities entities;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("machine_only")
    @Expose
    private Boolean machineOnly;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("thread_id")
    @Expose
    private String threadId;
    @SerializedName("pagination_id")
    @Expose
    private String paginationId;

    /**
     * No args constructor for use in serialization
     */
    public Datum() {
    }

    /**
     * @param text
     * @param threadId
     * @param numStars
     * @param entities
     * @param id
     * @param paginationId
     * @param numReposts
     * @param numReplies
     * @param source
     * @param createdAt
     * @param canonicalUrl
     * @param machineOnly
     * @param html
     * @param user
     */
    public Datum(String createdAt, Integer numStars, Integer numReplies, Source source, String text, Integer numReposts, String id, String canonicalUrl, Entities entities, String html, Boolean machineOnly, User user, String threadId, String paginationId) {
        this.createdAt = createdAt;
        this.numStars = numStars;
        this.numReplies = numReplies;
        this.source = source;
        this.text = text;
        this.numReposts = numReposts;
        this.id = id;
        this.canonicalUrl = canonicalUrl;
        this.entities = entities;
        this.html = html;
        this.machineOnly = machineOnly;
        this.user = user;
        this.threadId = threadId;
        this.paginationId = paginationId;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The numStars
     */
    public Integer getNumStars() {
        return numStars;
    }

    /**
     * @param numStars The num_stars
     */
    public void setNumStars(Integer numStars) {
        this.numStars = numStars;
    }

    /**
     * @return The numReplies
     */
    public Integer getNumReplies() {
        return numReplies;
    }

    /**
     * @param numReplies The num_replies
     */
    public void setNumReplies(Integer numReplies) {
        this.numReplies = numReplies;
    }

    /**
     * @return The source
     */
    public Source getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The numReposts
     */
    public Integer getNumReposts() {
        return numReposts;
    }

    /**
     * @param numReposts The num_reposts
     */
    public void setNumReposts(Integer numReposts) {
        this.numReposts = numReposts;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     * @param canonicalUrl The canonical_url
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     * @return The entities
     */
    public Entities getEntities() {
        return entities;
    }

    /**
     * @param entities The entities
     */
    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    /**
     * @return The html
     */
    public String getHtml() {
        return html;
    }

    /**
     * @param html The html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * @return The machineOnly
     */
    public Boolean getMachineOnly() {
        return machineOnly;
    }

    /**
     * @param machineOnly The machine_only
     */
    public void setMachineOnly(Boolean machineOnly) {
        this.machineOnly = machineOnly;
    }

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return The threadId
     */
    public String getThreadId() {
        return threadId;
    }

    /**
     * @param threadId The thread_id
     */
    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    /**
     * @return The paginationId
     */
    public String getPaginationId() {
        return paginationId;
    }

    /**
     * @param paginationId The pagination_id
     */
    public void setPaginationId(String paginationId) {
        this.paginationId = paginationId;
    }

}
