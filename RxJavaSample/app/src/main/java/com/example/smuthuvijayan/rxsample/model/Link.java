
package com.example.smuthuvijayan.rxsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */

public class Link {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("pos")
    @Expose
    private Integer pos;
    @SerializedName("len")
    @Expose
    private Integer len;

    /**
     * No args constructor for use in serialization
     */
    public Link() {
    }

    /**
     * @param text
     * @param len
     * @param url
     * @param pos
     */
    public Link(String url, String text, Integer pos, Integer len) {
        this.url = url;
        this.text = text;
        this.pos = pos;
        this.len = len;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
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
     * @return The pos
     */
    public Integer getPos() {
        return pos;
    }

    /**
     * @param pos The pos
     */
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    /**
     * @return The len
     */
    public Integer getLen() {
        return len;
    }

    /**
     * @param len The len
     */
    public void setLen(Integer len) {
        this.len = len;
    }

}
