package com.blog.userInfo.entity;

import java.util.List;

import javax.persistence.Embedded;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class UserInfo {

	@Id
	private String id;
	private String name;
	private String role;
//	@Indexed(unique = true)
	private String email;
	private String password;
//	@Indexed(unique = true)
	private String phoneNo;
	private String imagePath;
	@Embedded
	private Address address;
	@Transient
	private List<Review> review;
}
