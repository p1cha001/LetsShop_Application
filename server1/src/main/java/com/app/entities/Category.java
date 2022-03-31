package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "category")
public class Category extends BaseEntity{

	private String categoryTitle;
	
	private String description;
	
	@OneToMany(mappedBy = "selectedCategory",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("selectedCategory")
	private List<Product> products=new ArrayList<>();

public Category() {
	System.out.println("In Category default Constructor");
}

public Category(String categoryTitle, String description) {
	super();
	this.categoryTitle = categoryTitle;
	this.description = description;
	this.products=products;
}

@Override
public String toString() {
	return "Category [categoryTitle=" + categoryTitle + ", description=" + description + ",Id="+getId() +"]";
}

public String getCategoryTitle() {
	return categoryTitle;
}

public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

}
