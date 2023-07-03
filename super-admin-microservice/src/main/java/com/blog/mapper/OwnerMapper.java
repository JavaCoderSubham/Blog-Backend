package com.blog.mapper;

import org.springframework.stereotype.Component;

import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;

@Component
public class OwnerMapper {

	public static OwnerDto mapToOwnerDto(Owner owner) {
		OwnerDto ownerdto = new OwnerDto(
				             owner.getId(),
				             owner.getName(),
				             owner.getEmail(),
				             owner.getPassword(),
				             owner.getMobileNo(),
				             owner.getRole());
		return ownerdto;
	}
	
	public static Owner mapToOwner(OwnerDto dto) {
		Owner owner = new Owner(
				                dto.getId(),
				                dto.getName(),
				                dto.getEmail(),
				                dto.getPassword(),
				                dto.getMobileNo(),
				                dto.getRole()
				);
		
		return owner;
	}
}
