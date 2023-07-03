package com.blog.userInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.userInfo.dao.UserDetailsDao;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.exception.RecordNotFound;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Override
	public UserInfo create(UserInfo user) {
		return userDetailsDao.create(user);
	}

	@Override
	public List<UserInfo> getAll() {
		return userDetailsDao.getAll();
	}

	@Override
	public UserInfo getById(String id) throws RecordNotFound {
		
		return userDetailsDao.getById(id);
	}

	@Override
	public String deleteById(String id) throws RecordNotFound {
		
		return userDetailsDao.deleteById(id);
	}

	@Override
	public UserInfo update(UserInfo userDetails, String id) {
		
		return userDetailsDao.update(userDetails, id);
	}

	@Override
	public List<UserInfo> findByName(String name) throws RecordNotFound {
		
		return userDetailsDao.findByName(name);
	}

	@Override
	public UserInfo findByEmail(String email) throws RecordNotFound {
		
		return userDetailsDao.findByEmail(email);
	}

	@Override
	public UserInfo findByPhoneNo(String phoneNo) throws RecordNotFound {
		
		return userDetailsDao.findByPhoneNo(phoneNo);
	}
	
	
	
	
}
