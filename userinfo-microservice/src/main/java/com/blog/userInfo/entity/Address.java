package com.blog.userInfo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Address {

	
	private String city;
	private String state;
	private int pincode;
	private String fullAddress;
	
}
