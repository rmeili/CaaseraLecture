
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
        "assignmentId",
        "completedOn",
        "createdOn",
        "description",
        "isDenied",
        "reasonDenied",
        "studentFeedback",
        "title",
        "uploadUrl"
})
public class StudentAssignment {

    @JsonProperty("assignmentId")
    private String assignmentId;
    @JsonProperty("completedOn")
    private Object completedOn;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isDenied")
    private boolean isDenied;
    @JsonProperty("reasonDenied")
    private Object reasonDenied;
    @JsonProperty("studentFeedback")
    private List<Object> studentFeedback = null;
    @JsonProperty("title")
    private String title;
    @JsonProperty("uploadUrl")
    private Object uploadUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StudentAssignment() {
    }

    /**
     * @param uploadUrl
     * @param createdOn
     * @param reasonDenied
     * @param completedOn
     * @param title
     * @param isDenied
     * @param description
     * @param studentFeedback
     * @param assignmentId
     */
    public StudentAssignment(String assignmentId, Object completedOn, String createdOn, String description, boolean isDenied, Object reasonDenied, List<Object> studentFeedback, String title, Object uploadUrl) {
        super();
        this.assignmentId = assignmentId;
        this.completedOn = completedOn;
        this.createdOn = createdOn;
        this.description = description;
        this.isDenied = isDenied;
        this.reasonDenied = reasonDenied;
        this.studentFeedback = studentFeedback;
        this.title = title;
        this.uploadUrl = uploadUrl;
    }

    @JsonProperty("assignmentId")
    public String getAssignmentId() {
        return assignmentId;
    }

    @JsonProperty("assignmentId")
    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("isDenied")
    public boolean isIsDenied() {
        return isDenied;
    }

    @JsonProperty("isDenied")
    public void setIsDenied(boolean isDenied) {
        this.isDenied = isDenied;
    }

    @JsonProperty("reasonDenied")
    public Object getReasonDenied() {
        return reasonDenied;
    }

    @JsonProperty("reasonDenied")
    public void setReasonDenied(Object reasonDenied) {
        this.reasonDenied = reasonDenied;
    }

    @JsonProperty("studentFeedback")
    public List<Object> getStudentFeedback() {
        return studentFeedback;
    }

    @JsonProperty("studentFeedback")
    public void setStudentFeedback(List<Object> studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("uploadUrl")
    public Object getUploadUrl() {
        return uploadUrl;
    }

    @JsonProperty("uploadUrl")
    public void setUploadUrl(Object uploadUrl) {
        this.uploadUrl = uploadUrl;
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
