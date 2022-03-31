package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product extends BaseEntity{


	private String name;
	private double price;
	private int availQuantity;
	private String description;
	private String productPhotoUrl;
	private Double productDiscount;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate arrivalDateOfProduct;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
	@JsonIgnoreProperties("products")
	private Category selectedCategory;
	
	public Product() {
		System.out.println("In Product default Const");
		}


		public Product(String name, double price, Category selectedCategory, int availQuantity, String description,
				String productPhotoUrl, double productDiscount, LocalDate arrivalDateOfProduct) {
			super();
			this.name = name;
			this.price = price;
			this.selectedCategory = selectedCategory;
			this.availQuantity = availQuantity;
			this.description = description;
			this.productPhotoUrl = productPhotoUrl;
			this.productDiscount = productDiscount;
			this.arrivalDateOfProduct = arrivalDateOfProduct;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public Category getSelectedCategory() {
			return selectedCategory;
		}


		public void setSelectedCategory(Category selectedCategory) {
			this.selectedCategory = selectedCategory;
		}


		public int getAvailQuantity() {
			return availQuantity;
		}


		public void setAvailQuantity(int availQuantity) {
			this.availQuantity = availQuantity;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getProductPhotoUrl() {
			return productPhotoUrl;
		}


		public void setProductPhotoUrl(String productPhotoUrl) {
			this.productPhotoUrl = productPhotoUrl;
		}


		public double getProductDiscount() {
			return productDiscount;
		}


		public void setProductDiscount(double productDiscount) {
			this.productDiscount = productDiscount;
		}


		public LocalDate getArrivalDateOfProduct() {
			return arrivalDateOfProduct;
		}


		public void setArrivalDateOfProduct(LocalDate arrivalDateOfProduct) {
			this.arrivalDateOfProduct = arrivalDateOfProduct;
		}
		
	}
	
