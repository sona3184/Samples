
package com.karson.portfolio.adnfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */
public class Meta {

    @SerializedName("min_id")
    @Expose
    private String minId;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("max_id")
    @Expose
    private String maxId;
    @SerializedName("more")
    @Expose
    private Boolean more;

    /**
     * No args constructor for use in serialization
     */
    public Meta() {
    }

    /**
     * @param more
     * @param code
     * @param maxId
     * @param minId
     */
    public Meta(String minId, Integer code, String maxId, Boolean more) {
        this.minId = minId;
        this.code = code;
        this.maxId = maxId;
        this.more = more;
    }

    /**
     * @return The minId
     */
    public String getMinId() {
        return minId;
    }

    /**
     * @param minId The min_id
     */
    public void setMinId(String minId) {
        this.minId = minId;
    }

    /**
     * @return The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return The maxId
     */
    public String getMaxId() {
        return maxId;
    }

    /**
     * @param maxId The max_id
     */
    public void setMaxId(String maxId) {
        this.maxId = maxId;
    }

    /**
     * @return The more
     */
    public Boolean getMore() {
        return more;
    }

    /**
     * @param more The more
     */
    public void setMore(Boolean more) {
        this.more = more;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "minId='" + minId + '\'' +
                ", code=" + code +
                ", maxId='" + maxId + '\'' +
                ", more=" + more +
                '}';
    }
}
