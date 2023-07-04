package com.blog.userInfo.entity;

import javax.persistence.Embeddable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {

	private String city;
	private String state;
	private int pincode;
	private String fullAddress;
	
}
