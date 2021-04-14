
package com.janaagraha.dto;

import java.util.HashMap;
import java.util.Map;
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
    "subCategoryName",
    "subCategoryDistance",
    "comments",
    "latLong",
    "image"
})
public class SubCategory {

    /**
     * Id of the Sub category
     * <p>
     * 
     * 
     */
    @JsonProperty("id")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String id;
    /**
     * Sub Category Name
     * <p>
     * 
     * 
     */
    @JsonProperty("subCategoryName")
    @Pattern(regexp = "^([A-Za-z0-9]{1,128})$")
    private String subCategoryName;
    /**
     * Distance Calculated for SubCategory
     * <p>
     * 
     * 
     */
    @JsonProperty("subCategoryDistance")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String subCategoryDistance;
    /**
     * Comments for each subcategory
     * <p>
     * 
     * 
     */
    @JsonProperty("comments")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String comments;
    /**
     * Lat Long for each subcategory
     * <p>
     * 
     * 
     */
    @JsonProperty("latLong")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String latLong;
    /**
     * Image for each subcategory
     * <p>
     * 
     * 
     */
    @JsonProperty("image")
    @Pattern(regexp = "^([A-Za-z0-9]{1,64})$")
    private String image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Id of the Sub category
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
     * Id of the Sub category
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
     * Sub Category Name
     * <p>
     * 
     * 
     * @return
     *     The subCategoryName
     */
    @JsonProperty("subCategoryName")
    public String getSubCategoryName() {
        return subCategoryName;
    }

    /**
     * Sub Category Name
     * <p>
     * 
     * 
     * @param subCategoryName
     *     The subCategoryName
     */
    @JsonProperty("subCategoryName")
    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    /**
     * Distance Calculated for SubCategory
     * <p>
     * 
     * 
     * @return
     *     The subCategoryDistance
     */
    @JsonProperty("subCategoryDistance")
    public String getSubCategoryDistance() {
        return subCategoryDistance;
    }

    /**
     * Distance Calculated for SubCategory
     * <p>
     * 
     * 
     * @param subCategoryDistance
     *     The subCategoryDistance
     */
    @JsonProperty("subCategoryDistance")
    public void setSubCategoryDistance(String subCategoryDistance) {
        this.subCategoryDistance = subCategoryDistance;
    }

    /**
     * Comments for each subcategory
     * <p>
     * 
     * 
     * @return
     *     The comments
     */
    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    /**
     * Comments for each subcategory
     * <p>
     * 
     * 
     * @param comments
     *     The comments
     */
    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Lat Long for each subcategory
     * <p>
     * 
     * 
     * @return
     *     The latLong
     */
    @JsonProperty("latLong")
    public String getLatLong() {
        return latLong;
    }

    /**
     * Lat Long for each subcategory
     * <p>
     * 
     * 
     * @param latLong
     *     The latLong
     */
    @JsonProperty("latLong")
    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    /**
     * Image for each subcategory
     * <p>
     * 
     * 
     * @return
     *     The image
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Image for each subcategory
     * <p>
     * 
     * 
     * @param image
     *     The image
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
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
        return new HashCodeBuilder().append(id).append(subCategoryName).append(subCategoryDistance).append(comments).append(latLong).append(image).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubCategory) == false) {
            return false;
        }
        SubCategory rhs = ((SubCategory) other);
        return new EqualsBuilder().append(id, rhs.id).append(subCategoryName, rhs.subCategoryName).append(subCategoryDistance, rhs.subCategoryDistance).append(comments, rhs.comments).append(latLong, rhs.latLong).append(image, rhs.image).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
