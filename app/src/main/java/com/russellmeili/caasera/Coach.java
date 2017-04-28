
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
        "avatarUri",
        "name"
})
public class Coach {

    @JsonProperty("avatarUri")
    private String avatarUri;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Coach() {
    }

    /**
     * @param avatarUri
     * @param name
     */
    public Coach(String avatarUri, String name) {
        super();
        this.avatarUri = avatarUri;
        this.name = name;
    }

    @JsonProperty("avatarUri")
    public String getAvatarUri() {
        return avatarUri;
    }

    @JsonProperty("avatarUri")
    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
