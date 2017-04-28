
package com.russellmeili.caasera;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sport",
        "sportCategory",
        "subscriptionId"
})
public class AvailableSubscription {

    @JsonProperty("sport")
    private String sport;
    @JsonProperty("sportCategory")
    private String sportCategory;
    @JsonProperty("subscriptionId")
    private String subscriptionId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AvailableSubscription() {
    }

    /**
     * @param sportCategory
     * @param sport
     * @param subscriptionId
     */
    public AvailableSubscription(String sport, String sportCategory, String subscriptionId) {
        super();
        this.sport = sport;
        this.sportCategory = sportCategory;
        this.subscriptionId = subscriptionId;
    }

    @JsonProperty("sport")
    public String getSport() {
        return sport;
    }

    @JsonProperty("sport")
    public void setSport(String sport) {
        this.sport = sport;
    }

    @JsonProperty("sportCategory")
    public String getSportCategory() {
        return sportCategory;
    }

    @JsonProperty("sportCategory")
    public void setSportCategory(String sportCategory) {
        this.sportCategory = sportCategory;
    }

    @JsonProperty("subscriptionId")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    @JsonProperty("subscriptionId")
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
