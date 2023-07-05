package com.blog.admin.service;

import java.util.List;

import com.blog.admin.entity.Admin;

public interface AdminService {
	Admin createAdmin(Admin admin);

	Admin findAdminByEmail(String email);

	Admin findAdminByAadhar(String aadharNumber);

	Admin findAdminByMobileNumber(String mobileNumber);
	
	List<Admin> findAllAdmins();

	List<Admin> findAdminByAddressCity(String city);

	List<Admin> findAdminByAddressState(String state);

	List<Admin> findAdminByAddressPincode(Integer pincode);

	void changePassword(String email, String newPassword);

	Admin updateAdminById(String id, Admin admin);

	Admin updateAdminByEmail(String email, Admin admin);

	Admin updateAdminByMobileNumber(String mobileNumber, Admin admin);

	void deleteAdminByEmail(String email);

	void deleteAdminById(String id);

	void deleteAdminByMobileNumber(String mobileNumber);
}
