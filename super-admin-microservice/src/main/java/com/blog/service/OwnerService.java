package com.blog.service;

import com.blog.entity.Owner;

public interface OwnerService {

	public Owner create(Owner owner);
	
	public Owner getById(String id);
	
	public Owner update (String id, Owner owner);
	
	public void delete(String id);
}
