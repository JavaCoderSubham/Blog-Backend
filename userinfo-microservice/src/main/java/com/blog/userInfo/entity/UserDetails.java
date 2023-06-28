package com.blog.userInfo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
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
	private String id;
	private String name;
	@Indexed(unique = true)
	private String email;
	private String password;
	@Indexed(unique = true)
	private long phoneNo;
	private String imagePath;
	private Address address;
	@Transient
	List<Review> review;
}
