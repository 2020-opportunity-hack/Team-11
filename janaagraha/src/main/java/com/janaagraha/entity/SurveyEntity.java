package com.janaagraha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "survey")
public class SurveyEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
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
