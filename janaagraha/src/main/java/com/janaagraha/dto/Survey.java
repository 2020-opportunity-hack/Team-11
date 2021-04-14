
package com.janaagraha.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "surveyName",
    "category"
})
public class Survey {

    /**
     * Id of the survey
     * <p>
     *
     *
     */
    @JsonProperty("id")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String id;
    /**
     * Name of the Survey - Optional
     * <p>
     *
     *
     */
    @JsonProperty("surveyName")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String surveyName;
    /**
     * Category
     * <p>
     *
     *
     */
    @JsonProperty("category")
    @Valid
    private Category category;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Id of the survey
     * <p>
     *
     *
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Id of the survey
     * <p>
     *
     *
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name of the Survey - Optional
     * <p>
     *
     *
     * @return
     *     The surveyName
     */
    @JsonProperty("surveyName")
    public String getSurveyName() {
        return surveyName;
    }

    /**
     * Name of the Survey - Optional
     * <p>
     *
     *
     * @param surveyName
     *     The surveyName
     */
    @JsonProperty("surveyName")
    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    /**
     * Category
     * <p>
     *
     *
     * @return
     *     The category
     */
    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    /**
     * Category
     * <p>
     *
     *
     * @param category
     *     The category
     */
    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(surveyName).append(category).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Survey) == false) {
            return false;
        }
        Survey rhs = ((Survey) other);
        return new EqualsBuilder().append(id, rhs.id).append(surveyName, rhs.surveyName).append(category, rhs.category).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
