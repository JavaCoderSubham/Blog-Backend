package com.blog.admin.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.admin.entity.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{

	Optional<Admin> findAdminByEmail(String email);
	
}
