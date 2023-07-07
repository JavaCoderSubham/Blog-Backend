package com.blog.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.Owner;

@Repository
public interface OwnerRepository extends MongoRepository<Owner, String>{
	

	public Optional<Owner> findByEmail(String email);
	
	public Optional<Owner> findByMobileNo(String mobileNo);
}

