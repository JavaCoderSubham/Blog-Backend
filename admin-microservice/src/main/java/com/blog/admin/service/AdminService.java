package com.blog.admin.service;

import java.util.List;

import com.blog.admin.entity.Admin;
import com.blog.admin.entity.AdminDto;

public interface AdminService {
	Admin createAdmin(Admin admin);

	AdminDto findAdminByEmail(String email);

	AdminDto findAdminByAadhar(String aadharNumber);

	AdminDto findAdminByMobileNumber(String mobileNumber);
	
	List<AdminDto> findAllAdmins();

	List<AdminDto> findAdminByAddressCity(String city);

	List<AdminDto> findAdminByAddressState(String state);

	List<AdminDto> findAdminByAddressPincode(Integer pincode);

	void changePassword(String email, String newPassword);

	AdminDto updateAdminById(String id, AdminDto admin);

	AdminDto updateAdminByEmail(String email, AdminDto updatedAdminDto);

	AdminDto updateAdminByMobileNumber(String mobileNumber, AdminDto updatedAdminDto);

	void deleteAdminByEmail(String email);

	void deleteAdminById(String id);

	void deleteAdminByMobileNumber(String mobileNumber);
}
