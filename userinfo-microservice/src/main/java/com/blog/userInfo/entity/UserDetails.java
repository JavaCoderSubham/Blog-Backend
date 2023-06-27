package com.blog.userInfo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class UserDetails {

	@Id
	private int id;
	private String name;
	private String email;
	private String password;
	private int phoneNo;
	private String imagePath;
	private Address address;
	@Transient
	List<Review> review;
}
