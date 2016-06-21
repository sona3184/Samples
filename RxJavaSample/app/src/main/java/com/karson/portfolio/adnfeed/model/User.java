
package com.karson.portfolio.adnfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */
public class User {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("avatar_image")
    @Expose
    private AvatarImage avatarImage;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("canonical_url")
    @Expose
    private String canonicalUrl;
    @SerializedName("cover_image")
    @Expose
    private CoverImage coverImage;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("counts")
    @Expose
    private Counts counts;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public User() {
    }

    /**
     * @param id
     * @param timezone
     * @param avatarImage
     * @param username
     * @param canonicalUrl
     * @param createdAt
     * @param description
     * @param name
     * @param locale
     * @param counts
     * @param type
     * @param coverImage
     */
    public User(String username, AvatarImage avatarImage, Description description, String locale, String createdAt, String canonicalUrl, CoverImage coverImage, String timezone, Counts counts, String type, String id, String name) {
        this.username = username;
        this.avatarImage = avatarImage;
        this.description = description;
        this.locale = locale;
        this.createdAt = createdAt;
        this.canonicalUrl = canonicalUrl;
        this.coverImage = coverImage;
        this.timezone = timezone;
        this.counts = counts;
        this.type = type;
        this.id = id;
        this.name = name;
    }

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The avatarImage
     */
    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    /**
     * @param avatarImage The avatar_image
     */
    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    /**
     * @return The description
     */
    public Description getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * @return The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
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
     * @return The coverImage
     */
    public CoverImage getCoverImage() {
        return coverImage;
    }

    /**
     * @param coverImage The cover_image
     */
    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    /**
     * @return The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * @param timezone The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * @return The counts
     */
    public Counts getCounts() {
        return counts;
    }

    /**
     * @param counts The counts
     */
    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
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
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
