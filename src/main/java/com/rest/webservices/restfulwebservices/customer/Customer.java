package com.rest.webservices.restfulwebservices.customer;


import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Customer {
	
	private Integer id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@Email
	private String email;
	
	protected Customer() {

	}

	public Customer(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, birthDate=%s]", id, name, email);
	}

	

}
