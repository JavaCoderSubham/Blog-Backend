package com.blog.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Admin {
	private String id;
	private String name;
	private String email;
	private String password;
	private Address address;
	private String aadharNumber;
	private String role;
}
