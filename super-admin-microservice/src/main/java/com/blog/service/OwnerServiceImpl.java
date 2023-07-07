package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dao.OwnerDao;
import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;

@Service
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private  OwnerDao ownerDao;
	
	@Autowired
	public OwnerServiceImpl(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}

	@Override
	public Owner create(Owner owner) {
		
		Owner create = ownerDao.create(owner);
		
		return create;
	}

	@Override
	public OwnerDto getById(String id) {
		OwnerDto get = ownerDao.getById(id);
		return get;
	}

	@Override
	public OwnerDto update(String id, Owner owner) {
		OwnerDto update = ownerDao.update(id, owner);
		return update;
	}

	@Override
	public String delete(String id) {
		String delete = ownerDao.delete(id);
		return delete;
		
	}

	//**********************************//
	
	@Override
	public OwnerDto findByEmail(String email) {
		OwnerDto findByEmail = ownerDao.findByEmail(email);
		return findByEmail;
	} 
	
	public OwnerDto findByMobileNo(String mobileNo) {
		OwnerDto findByMobileNo = ownerDao.findBymobileNo(mobileNo);
		return findByMobileNo;
	}

	@Override
	public void changePassword(String email, String password) {
		ownerDao.changePassword(email, password);
		
	}

	 
}
