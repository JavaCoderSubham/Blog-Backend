package com.blog.admin.service;

import com.blog.admin.entity.Admin;

public interface AdminService {
	Admin createAdmin(Admin admin);
	
	Admin findAdminByEmail(String email);
}
