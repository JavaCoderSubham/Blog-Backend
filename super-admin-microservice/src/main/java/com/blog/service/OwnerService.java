package com.blog.service;

import com.blog.dto.OwnerDto;

public interface OwnerService {

	public OwnerDto create(OwnerDto owner);
	
	public OwnerDto getById(String id);
	
	public OwnerDto update (String id, OwnerDto owner);
	
	public void delete(String id);
}
