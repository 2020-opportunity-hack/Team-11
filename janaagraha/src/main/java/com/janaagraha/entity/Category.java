package com.janaagraha.entity;

import java.util.List;

public class Category {
	private String categoryName;
	private String categoryDistance;
	private List<SubCategory> subCategories;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDistance() {
		return categoryDistance;
	}

	public void setCategoryDistance(String categoryDistance) {
		this.categoryDistance = categoryDistance;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

}
