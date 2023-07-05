package com.blog.admin.entity.dao;

import java.util.List;

import com.blog.admin.entity.Admin;

public interface AdminDao {
	Admin createAdmin(Admin admin);
	
	Admin findAdminByEmail(String email);
	
	Admin findAdminById(String id);
	
//	public boolean emailOrMobileAlreadyExist(Admin admin);
//	
//	public boolean aadharAlreadyExist(Admin admin);
	
	Admin findAdminByAadhar(String aadharNumber);
	
	Admin findAdminByMobileNumber(String mobileNumber);
	
	List<Admin> findAllAdmins();
	
	List<Admin> findAdminByAddressCity(String city);
	
	List<Admin> findAdminByAddressState(String state);
	
	List<Admin> findAdminByAddressPincode(Integer pincode);
	
	void changePassword(String id, String newPassword);
	
	Admin updateAdminById(String id, Admin updatedAdmin);
	
	Admin updateAdminByEmail(String email, Admin updatedAdmin);
	
	Admin updateAdminByMobileNumber(String mobileNumber, Admin updatedAdmin);
	
	void deleteAdminByEmail(String email);
	
	void deleteAdminById(String id);
	
    void deleteAdminByMobileNumber(String mobileNumber);
}
