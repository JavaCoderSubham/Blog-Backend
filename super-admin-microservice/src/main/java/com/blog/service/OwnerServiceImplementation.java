package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;
import com.blog.repository.OwnerRepository;

@Service
public class OwnerServiceImplementation implements OwnerService{
	
	
	@Autowired
	public OwnerRepository ownerRepository;

	@Override
	public OwnerDto create(OwnerDto owner) {
		 
		return ownerRepository.save(owner);
	}

	@Override
	public OwnerDto getById(String id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public OwnerDto update(String id, OwnerDto owner) {
		owner.setId(id);
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(String id) {
		ownerRepository.deleteById(id);
		
	}

	
}
