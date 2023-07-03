package com.blog.dto;

import com.blog.entity.Owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {

	public OwnerDto(Owner owner) {
		this.id=owner.getId();
		this.name=owner.getName();
		this.email=owner.getEmail();
		this.password=owner.getPassword();
		this.mobileNo=owner.getMobileNo();
		this.role=owner.getRole();
	}
	private String id;
	private String name;
	private String email;
	private String password;
	private String mobileNo;
	private String role;
	
}
