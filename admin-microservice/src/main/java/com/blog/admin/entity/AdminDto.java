package com.blog.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
	private String id;
	private String name;
	private String email;
	private String mobileNumber;
	private Address address;
	private String aadharNumber;
	private String role;
}
