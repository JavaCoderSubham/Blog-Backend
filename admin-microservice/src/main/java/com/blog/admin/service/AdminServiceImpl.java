package com.blog.admin.service;

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
	public Admin findAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
