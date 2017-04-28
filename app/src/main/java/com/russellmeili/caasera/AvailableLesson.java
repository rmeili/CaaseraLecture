
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
        "completedOn",
        "createdOn",
        "lessonId",
        "lessonNumber",
        "status"
})
public class AvailableLesson {

    @JsonProperty("completedOn")
    private Object completedOn;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("lessonId")
    private String lessonId;
    @JsonProperty("lessonNumber")
    private int lessonNumber;
    @JsonProperty("status")
    private int status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AvailableLesson() {
    }

    /**
     * @param createdOn
     * @param completedOn
     * @param lessonId
     * @param status
     * @param lessonNumber
     */
    public AvailableLesson(Object completedOn, String createdOn, String lessonId, int lessonNumber, int status) {
        super();
        this.completedOn = completedOn;
        this.createdOn = createdOn;
        this.lessonId = lessonId;
        this.lessonNumber = lessonNumber;
        this.status = status;
    }

    @JsonProperty("completedOn")
    public Object getCompletedOn() {
        return completedOn;
    }

    @JsonProperty("completedOn")
    public void setCompletedOn(Object completedOn) {
        this.completedOn = completedOn;
    }

    @JsonProperty("createdOn")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("lessonId")
    public String getLessonId() {
        return lessonId;
    }

    @JsonProperty("lessonId")
    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    @JsonProperty("lessonNumber")
    public int getLessonNumber() {
        return lessonNumber;
    }

    @JsonProperty("lessonNumber")
    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(int status) {
        this.status = status;
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
