package com.metacube.springJDBC.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Employee {
	
	Integer id;
	
	@NotBlank(message="Field Can't be empty")
	String name;
	@NotBlank(message="Field Can't be empty")
	String gender;
	
	@NotBlank(message="Field Can't be empty")
	String email;
	
	@NotBlank(message="Field Can't be empty")
	String password;
	
	String cpassword;
	
	@NotBlank(message="Field Can't be empty")
	@Size(min=10 , max=10 , message="Should be 10 digit")
	String contact;
	
	Integer organization_id;
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + id + ", name=" + name + ", gender="
				+ gender + ", email=" + email + ", password=" + password
				+ ", cpassword=" + cpassword + ", contact=" + contact
				+ ", organization_id=" + organization_id + "]";
	}
	
	
	

}
