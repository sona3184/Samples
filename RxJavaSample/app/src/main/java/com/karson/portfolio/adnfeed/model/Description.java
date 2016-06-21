
package com.karson.portfolio.adnfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */

public class Description {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("entities")
    @Expose
    private Entities entities;

    /**
     * No args constructor for use in serialization
     */
    public Description() {
    }

    /**
     * @param text
     * @param html
     * @param entities
     */
    public Description(String text, String html, Entities entities) {
        this.text = text;
        this.html = html;
        this.entities = entities;
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

}
