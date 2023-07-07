package com.blog.service;

import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;

public interface OwnerService {

	public Owner create(Owner owner);
	
	public OwnerDto getById(String id);
	
	public OwnerDto update (String id, Owner owner);
	
	public String delete(String id);
	
	//********************************//
	
	public OwnerDto findByEmail(String email);
	
	public OwnerDto findByMobileNo(String mobileNo);
	
	void changePassword(String email, String password);
}
