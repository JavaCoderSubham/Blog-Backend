package com.blog.admin.entity.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.admin.entity.Admin;
import com.blog.admin.exceptions.AdminNotFoundException;
import com.blog.admin.exceptions.EmailAlreadyExistException;
import com.blog.admin.repository.AdminRepository;

@Service
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Admin createAdmin(Admin admin) {
		admin.setId(UUID.randomUUID().toString());
		admin.setRole("ROLE_ADMIN");
		if(emailAlreadyExist(admin)) {
			throw new EmailAlreadyExistException();
		}
		admin.setPassword(encoder.encode(admin.getPassword()));
		Admin save = adminRepository.save(admin);
		return save;
	}
	
	@Override
	public Admin findAdminByEmail(String email) {
		Admin optionalAdmin = adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminNotFoundException());
		return optionalAdmin;
	}
	
	public boolean emailAlreadyExist(Admin admin) {
		return adminRepository.findAdminByEmail(admin.getEmail()).isPresent();
	}
}
