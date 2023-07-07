package com.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {

	private String id;
	private String name;
	private String email;
	//private String password;
	private String mobileNo;
	private String role;
	
}
