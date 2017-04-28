
package com.russellmeili.caasera;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "availableLessons",
        "coach",
        "currentLesson",
        "sport",
        "sportCategory",
        "status",
        "subscriptionId",
        "type"
})
public class CurrentSubscription {

    @JsonProperty("availableLessons")
    private List<AvailableLesson> availableLessons = null;
    @JsonProperty("coach")
    private Coach coach;
    @JsonProperty("currentLesson")
    private CurrentLesson currentLesson;
    @JsonProperty("sport")
    private String sport;
    @JsonProperty("sportCategory")
    private String sportCategory;
    @JsonProperty("status")
    private int status;
    @JsonProperty("subscriptionId")
    private String subscriptionId;
    @JsonProperty("type")
    private int type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CurrentSubscription() {
    }

    /**
     * @param status
     * @param coach
     * @param sportCategory
     * @param sport
     * @param type
     * @param availableLessons
     * @param subscriptionId
     * @param currentLesson
     */
    public CurrentSubscription(List<AvailableLesson> availableLessons, Coach coach, CurrentLesson currentLesson, String sport, String sportCategory, int status, String subscriptionId, int type) {
        super();
        this.availableLessons = availableLessons;
        this.coach = coach;
        this.currentLesson = currentLesson;
        this.sport = sport;
        this.sportCategory = sportCategory;
        this.status = status;
        this.subscriptionId = subscriptionId;
        this.type = type;
    }

    @JsonProperty("availableLessons")
    public List<AvailableLesson> getAvailableLessons() {
        return availableLessons;
    }

    @JsonProperty("availableLessons")
    public void setAvailableLessons(List<AvailableLesson> availableLessons) {
        this.availableLessons = availableLessons;
    }

    @JsonProperty("coach")
    public Coach getCoach() {
        return coach;
    }

    @JsonProperty("coach")
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @JsonProperty("currentLesson")
    public CurrentLesson getCurrentLesson() {
        return currentLesson;
    }

    @JsonProperty("currentLesson")
    public void setCurrentLesson(CurrentLesson currentLesson) {
        this.currentLesson = currentLesson;
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

    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(int status) {
        this.status = status;
    }

    @JsonProperty("subscriptionId")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    @JsonProperty("subscriptionId")
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @JsonProperty("type")
    public int getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(int type) {
        this.type = type;
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
