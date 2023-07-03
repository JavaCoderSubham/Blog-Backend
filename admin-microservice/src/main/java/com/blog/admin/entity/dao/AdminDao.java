package com.blog.admin.entity.dao;

import com.blog.admin.entity.Admin;

public interface AdminDao {
	Admin createAdmin(Admin admin);
	
	Admin findAdminByEmail(String email);
	
	public boolean emailAlreadyExist(Admin admin);
}
