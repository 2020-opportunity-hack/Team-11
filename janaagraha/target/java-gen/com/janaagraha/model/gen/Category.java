
package com.janaagraha.model.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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


/**
 * Category
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "categoryName",
    "categoryDistance",
    "subCategories"
})
public class Category {

    /**
     * Id of the category
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
    @JsonProperty("categoryName")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String categoryName;
    /**
     * Distance calculated in the Category
     * <p>
     * 
     * 
     */
    @JsonProperty("categoryDistance")
    private Integer categoryDistance;
    @JsonProperty("subCategories")
    @Valid
    private List<SubCategory> subCategories = new ArrayList<SubCategory>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Id of the category
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
     * Id of the category
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
     *     The categoryName
     */
    @JsonProperty("categoryName")
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Name of the Survey - Optional
     * <p>
     * 
     * 
     * @param categoryName
     *     The categoryName
     */
    @JsonProperty("categoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Distance calculated in the Category
     * <p>
     * 
     * 
     * @return
     *     The categoryDistance
     */
    @JsonProperty("categoryDistance")
    public Integer getCategoryDistance() {
        return categoryDistance;
    }

    /**
     * Distance calculated in the Category
     * <p>
     * 
     * 
     * @param categoryDistance
     *     The categoryDistance
     */
    @JsonProperty("categoryDistance")
    public void setCategoryDistance(Integer categoryDistance) {
        this.categoryDistance = categoryDistance;
    }

    /**
     * 
     * @return
     *     The subCategories
     */
    @JsonProperty("subCategories")
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    /**
     * 
     * @param subCategories
     *     The subCategories
     */
    @JsonProperty("subCategories")
    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
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
        return new HashCodeBuilder().append(id).append(categoryName).append(categoryDistance).append(subCategories).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category) == false) {
            return false;
        }
        Category rhs = ((Category) other);
        return new EqualsBuilder().append(id, rhs.id).append(categoryName, rhs.categoryName).append(categoryDistance, rhs.categoryDistance).append(subCategories, rhs.subCategories).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
