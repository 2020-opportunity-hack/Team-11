package com.janaagraha.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document
public class SurveyEntity {

@Id
private Long id;
private CategoryEntity category;
private List<SubCategoryEntity> subCategories;

public CategoryEntity getCategory() {
    return category;
}

public void setCategory(CategoryEntity category) {
    this.category = category;
}

public List<SubCategoryEntity> getSubCategories() {
    return subCategories;
}

public void setSubCategories(List<SubCategoryEntity> subCategories) {
    this.subCategories = subCategories;
}

}
