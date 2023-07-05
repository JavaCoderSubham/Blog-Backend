package com.blog.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.admin.entity.Admin;
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
	public List<Admin> findAllAdmins() {
		return adminDao.findAllAdmins();
	}

	@Override
	public Admin findAdminByEmail(String email) {
		Admin admin = adminDao.findAdminByEmail(email);
		return admin;
	}

	@Override
	public Admin findAdminByAadhar(String aadharNumber) {
		Admin admin = adminDao.findAdminByAadhar(aadharNumber);
		return admin;
	}

	@Override
	public List<Admin> findAdminByAddressCity(String city) {
		List<Admin> admins = adminDao.findAdminByAddressCity(city);
		return admins;
	}

	@Override
	public List<Admin> findAdminByAddressState(String state) {
		List<Admin> admins = adminDao.findAdminByAddressCity(state);
		return admins;
	}

	@Override
	public List<Admin> findAdminByAddressPincode(Integer pincode) {
		List<Admin> admins = adminDao.findAdminByAddressPincode(pincode);
		return admins;
	}

	@Override
	public Admin findAdminByMobileNumber(String mobileNumber) {
		Admin admin = adminDao.findAdminByMobileNumber(mobileNumber);
		return admin;
	}

	@Override
	public void changePassword(String email, String newPassword) {
		adminDao.changePassword(email, newPassword);
	}

	@Override
	public Admin updateAdminById(String id, Admin admin) {
		Admin updatedAdmin = adminDao.updateAdminById(id, admin);
		return updatedAdmin;
	}

	@Override
	public Admin updateAdminByEmail(String email, Admin admin) {
		Admin updatedAdmin = adminDao.updateAdminByEmail(email, admin);
		return updatedAdmin;
	}

	@Override
	public Admin updateAdminByMobileNumber(String mobileNumber, Admin admin) {
		Admin updatedAdmin = adminDao.updateAdminByMobileNumber(mobileNumber, admin);
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
