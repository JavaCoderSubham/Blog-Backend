package com.blog.admin.entity.dao;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.admin.entity.Admin;
import com.blog.admin.exceptions.AadharAlreadyExistException;
import com.blog.admin.exceptions.AdminNotFoundException;
import com.blog.admin.exceptions.EmailOrMobileAlreadyExistException;
import com.blog.admin.exceptions.NoAdminsFoundException;
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
		if (emailOrMobileAlreadyExist(admin)) {
			throw new EmailOrMobileAlreadyExistException();
		}
		if (aadharAlreadyExist(admin)) {
			throw new AadharAlreadyExistException();
		}
		admin.setPassword(encoder.encode(admin.getPassword()));
		Admin save = adminRepository.save(admin);
		return save;
	}
	
	@Override
	public List<Admin> findAllAdmins() {
		List<Admin> list = adminRepository.findAll();
		return list;
	}

	@Override
	public Admin findAdminByEmail(String email) {
		Admin optionalAdmin = adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminNotFoundException());
		return optionalAdmin;
	}
	
	@Override
	public Admin findAdminById(String id) {
		Admin optionalAdmin = adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException());
		return optionalAdmin;
	}

	@Override
	public Admin findAdminByAadhar(String aadharNumber) {
		Admin optionalAdmin = adminRepository.findAdminByAadharNumber(aadharNumber)
				.orElseThrow(() -> new AdminNotFoundException());
		return optionalAdmin;
	}

	@Override
	public Admin findAdminByMobileNumber(String mobileNumber) {
		Admin optionalAdmin = adminRepository.findAdminByMobileNumber(mobileNumber)
				.orElseThrow(() -> new AdminNotFoundException());
		return optionalAdmin;
	}

	@Override
	public List<Admin> findAdminByAddressCity(String city) {
		List<Admin> admins = adminRepository.findByAddressCity(city);
		return admins;
	}

	@Override
	public List<Admin> findAdminByAddressState(String state) {
		List<Admin> admins = adminRepository.findByAddressCity(state);
		return admins;
	}

	@Override
	public List<Admin> findAdminByAddressPincode(Integer pincode) {
		List<Admin> admins = adminRepository.findByAddressPincode(pincode);
		return admins;
	}

	@Override
	public void changePassword(String email, String newPassword) {
		Admin admin = adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminNotFoundException());
		admin.setPassword(newPassword);
		adminRepository.save(admin);
	}

	private boolean emailOrMobileAlreadyExist(Admin admin) {
		return adminRepository.findAdminByEmail(admin.getEmail()).isPresent()
				| adminRepository.findAdminByMobileNumber(admin.getMobileNumber()).isPresent();
	}

	private boolean aadharAlreadyExist(Admin admin) {
		return adminRepository.findAdminByAadharNumber(admin.getAadharNumber()).isPresent();
	}
	
	@Override
	public Admin updateAdminById(String id, Admin updatedAdmin) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException());

        // Update only the fields that are allowed to be updated
        admin.setEmail(updatedAdmin.getEmail());
        admin.setMobileNumber(updatedAdmin.getMobileNumber());
        admin.setAddress(updatedAdmin.getAddress());

        return adminRepository.save(admin);
    }

	@Override
	public Admin updateAdminByEmail(String email, Admin updatedAdmin) {
		Admin admin = adminRepository.findAdminByEmail(email)
                .orElseThrow(() -> new AdminNotFoundException());

        // Update only the fields that are allowed to be updated
        admin.setEmail(updatedAdmin.getEmail());
        admin.setMobileNumber(updatedAdmin.getMobileNumber());
        admin.setAddress(updatedAdmin.getAddress());

        return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdminByMobileNumber(String mobileNumber, Admin updatedAdmin) {
		Admin admin = adminRepository.findAdminByMobileNumber(mobileNumber)
                .orElseThrow(() -> new AdminNotFoundException());

        // Update only the fields that are allowed to be updated
        admin.setEmail(updatedAdmin.getEmail());
        admin.setMobileNumber(updatedAdmin.getMobileNumber());
        admin.setAddress(updatedAdmin.getAddress());

        return adminRepository.save(admin);
	}

	@Override
	public void deleteAdminByEmail(String email) {
		adminRepository.deleteByEmail(email);
	}
	
	@Override
	public void deleteAdminById(String id) {
		adminRepository.deleteById(id);
	}

	@Override
	public void deleteAdminByMobileNumber(String mobileNumber) {
		adminRepository.deleteByMobileNumber(mobileNumber);
	}
}
