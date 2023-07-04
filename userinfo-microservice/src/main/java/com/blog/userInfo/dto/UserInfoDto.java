package com.blog.userInfo.dto;

import java.util.List;

import javax.persistence.Embedded;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.blog.userInfo.entity.Address;
import com.blog.userInfo.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

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
public class UserInfoDto {

	@Id
	private String id;
	private String name;
	private String role;
	private String email;
	@JsonIgnore
	private String pasword;
	private String phoneNo;
	private String imagePath;
	private Address address;
	@Transient
	private List<Review> review;
}
