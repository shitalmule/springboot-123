package com.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Validated
@Cacheable
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	@NotBlank(message = "Address should not e empty")
	private String uaddress;
	@JsonProperty(value = "uph")
	private String uphonenumber;
	private String gender;
	@NotBlank(message = " name should not be empty")
	private String username;
	
	private String acnumber;
	
	
	}
	


