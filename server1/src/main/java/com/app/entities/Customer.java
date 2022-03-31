package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer")
public class Customer {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String phone;
	private String role;
	private String profileImage;
	private int isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date createdTimestamp;
	
	
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}




	public Customer(int id, String firstName, String lastName, String password, String email, Date birthDate,
			String addressLine1, String addressLine2, String city, String state, String country, String postalCode,
			String phone, String role,String profileImage, int isActive, Date createdTimestamp) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.phone = phone;
		this.role =role;
		this.profileImage = profileImage;
		this.isActive = isActive;
		this.createdTimestamp = createdTimestamp;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Date getBirthDate() {
		return birthDate;
	}




	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}




	public String getAddressLine1() {
		return addressLine1;
	}




	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}




	public String getAddressLine2() {
		return addressLine2;
	}




	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getPostalCode() {
		return postalCode;
	}




	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getProfileImage() {
		return profileImage;
	}




	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}




	public int getIsActive() {
		return isActive;
	}




	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}




	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}




	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}




	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", birthDate=" + birthDate + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", phone=" + phone + ", profileImage=" + profileImage + ", isActive=" + isActive
				+ ", createdTimestamp=" + createdTimestamp + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
