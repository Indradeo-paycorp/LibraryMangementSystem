package com.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Phone number is mamdatory")
	private String phNo;
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
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	
	

}
