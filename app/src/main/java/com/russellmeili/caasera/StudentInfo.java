
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
        "availableSubscriptions",
        "currentSubscription",
        "firstName"
})
public class StudentInfo {

    @JsonProperty("availableSubscriptions")
    private List<AvailableSubscription> availableSubscriptions = null;
    @JsonProperty("currentSubscription")
    private CurrentSubscription currentSubscription;
    @JsonProperty("firstName")
    private String firstName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StudentInfo() {
    }

    /**
     * @param currentSubscription
     * @param availableSubscriptions
     * @param firstName
     */
    public StudentInfo(List<AvailableSubscription> availableSubscriptions, CurrentSubscription currentSubscription, String firstName) {
        super();
        this.availableSubscriptions = availableSubscriptions;
        this.currentSubscription = currentSubscription;
        this.firstName = firstName;
    }

    @JsonProperty("availableSubscriptions")
    public List<AvailableSubscription> getAvailableSubscriptions() {
        return availableSubscriptions;
    }

    @JsonProperty("availableSubscriptions")
    public void setAvailableSubscriptions(List<AvailableSubscription> availableSubscriptions) {
        this.availableSubscriptions = availableSubscriptions;
    }

    @JsonProperty("currentSubscription")
    public CurrentSubscription getCurrentSubscription() {
        return currentSubscription;
    }

    @JsonProperty("currentSubscription")
    public void setCurrentSubscription(CurrentSubscription currentSubscription) {
        this.currentSubscription = currentSubscription;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
