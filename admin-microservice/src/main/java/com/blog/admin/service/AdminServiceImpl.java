package com.blog.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.admin.entity.Admin;
import com.blog.admin.entity.AdminDto;
import com.blog.admin.entity.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin createAdmin(Admin admin) {
		Admin save = adminDao.createAdmin(admin);
		return save;
	}
	
	@Override
	public List<AdminDto> findAllAdmins() {
		return adminDao.findAllAdmins();
	}

	@Override
	public AdminDto findAdminByEmail(String email) {
		AdminDto admin = adminDao.findAdminByEmail(email);
		return admin;
	}

	@Override
	public AdminDto findAdminByAadhar(String aadharNumber) {
		AdminDto admin = adminDao.findAdminByAadhar(aadharNumber);
		return admin;
	}

	@Override
	public List<AdminDto> findAdminByAddressCity(String city) {
		List<AdminDto> admins = adminDao.findAdminByAddressCity(city);
		return admins;
	}

	@Override
	public List<AdminDto> findAdminByAddressState(String state) {
		List<AdminDto> admins = adminDao.findAdminByAddressCity(state);
		return admins;
	}

	@Override
	public List<AdminDto> findAdminByAddressPincode(Integer pincode) {
		List<AdminDto> admins = adminDao.findAdminByAddressPincode(pincode);
		return admins;
	}

	@Override
	public AdminDto findAdminByMobileNumber(String mobileNumber) {
		AdminDto admin = adminDao.findAdminByMobileNumber(mobileNumber);
		return admin;
	}

	@Override
	public void changePassword(String email, String newPassword) {
		adminDao.changePassword(email, newPassword);
	}

	@Override
	public AdminDto updateAdminById(String id, AdminDto admin) {
		AdminDto updatedAdmin = adminDao.updateAdminById(id, admin);
		return updatedAdmin;
	}

	@Override
	public AdminDto updateAdminByEmail(String email, AdminDto admin) {
		AdminDto updatedAdmin = adminDao.updateAdminByEmail(email, admin);
		return updatedAdmin;
	}

	@Override
	public AdminDto updateAdminByMobileNumber(String mobileNumber, AdminDto admin) {
		AdminDto updatedAdmin = adminDao.updateAdminByMobileNumber(mobileNumber, admin);
		return updatedAdmin;
	}

	@Override
	public void deleteAdminByEmail(String email) {
		adminDao.deleteAdminByEmail(email);
	}

	@Override
	public void deleteAdminById(String id) {
		adminDao.deleteAdminById(id);
	}

	@Override
	public void deleteAdminByMobileNumber(String mobileNumber) {
		adminDao.deleteAdminByMobileNumber(mobileNumber);
	}
}
