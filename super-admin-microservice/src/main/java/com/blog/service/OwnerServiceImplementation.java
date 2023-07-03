package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Owner;
import com.blog.repository.OwnerRepository;

@Service
public class OwnerServiceImplementation implements OwnerService{
	
	
	@Autowired
	public OwnerRepository ownerRepository;

	@Override
	public Owner create(Owner owner) {
		 
		return ownerRepository.save(owner);
	}

	@Override
	public Owner getById(String id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner update(String id, Owner owner) {
		owner.setId(id);
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(String id) {
		ownerRepository.deleteById(id);
		
	}

	
}
