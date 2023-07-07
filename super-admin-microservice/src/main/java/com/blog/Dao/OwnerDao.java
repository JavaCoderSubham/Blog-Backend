package com.blog.Dao;

import java.util.Optional;

import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;

public interface OwnerDao {

	public Owner create(Owner superAdmin);

	public OwnerDto getById(String id);

	public OwnerDto update(String id, Owner owner);

	public String delete(String id);
	
	//*************************************//
	
	public OwnerDto findByEmail(String email);
	
	public OwnerDto findBymobileNo(String mobileNo);
	
	public boolean emailOrMobileNoExist(Owner owner);
	
	void changePassword(String email, String password);
}
