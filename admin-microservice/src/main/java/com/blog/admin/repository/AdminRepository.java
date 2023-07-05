package com.blog.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.admin.entity.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{

	Optional<Admin> findAdminByEmail(String email);
	
	Optional<Admin> findAdminByAadharNumber(String aadharNumber);
	
	Optional<Admin> findAdminByMobileNumber(String mobileNumber);
	
	List<Admin> findByAddressCity(String city);
	
	List<Admin> findByAddressState(String state);
	
	List<Admin> findByAddressPincode(Integer pincode);
	
	void deleteByEmail(String email);
	
    void deleteByMobileNumber(String mobileNumber);
}
