
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
        "completedOn",
        "createdOn",
        "notes",
        "status",
        "studentAssignments",
        "studentExercises",
        "title"
})
public class CurrentLesson {

    @JsonProperty("completedOn")
    private Object completedOn;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("status")
    private int status;
    @JsonProperty("studentAssignments")
    private List<StudentAssignment> studentAssignments = null;
    @JsonProperty("studentExercises")
    private List<Object> studentExercises = null;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CurrentLesson() {
    }

    /**
     * @param createdOn
     * @param completedOn
     * @param title
     * @param studentExercises
     * @param status
     * @param studentAssignments
     * @param notes
     */
    public CurrentLesson(Object completedOn, String createdOn, String notes, int status, List<StudentAssignment> studentAssignments, List<Object> studentExercises, String title) {
        super();
        this.completedOn = completedOn;
        this.createdOn = createdOn;
        this.notes = notes;
        this.status = status;
        this.studentAssignments = studentAssignments;
        this.studentExercises = studentExercises;
        this.title = title;
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

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(int status) {
        this.status = status;
    }

    @JsonProperty("studentAssignments")
    public List<StudentAssignment> getStudentAssignments() {
        return studentAssignments;
    }

    @JsonProperty("studentAssignments")
    public void setStudentAssignments(List<StudentAssignment> studentAssignments) {
        this.studentAssignments = studentAssignments;
    }

    @JsonProperty("studentExercises")
    public List<Object> getStudentExercises() {
        return studentExercises;
    }

    @JsonProperty("studentExercises")
    public void setStudentExercises(List<Object> studentExercises) {
        this.studentExercises = studentExercises;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
