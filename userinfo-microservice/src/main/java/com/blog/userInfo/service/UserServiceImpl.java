package com.blog.userInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.userInfo.dao.UserDetailsDao;
import com.blog.userInfo.dto.UserInfoDto;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.entity.UserProjectionEmail;
import com.blog.userInfo.entity.UserProjectionPhoneNo;
import com.blog.userInfo.exception.RecordNotFound;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


	private final UserDetailsDao userDetailsDao;
	
	@Autowired
	public UserServiceImpl(UserDetailsDao userDetailsDao) {
		this.userDetailsDao = userDetailsDao;
	}
	

	@Override
	public UserInfo create(UserInfo user) {
		log.info("======== UserServiceImpl UserCreate Started ======= ");
		UserInfo create = userDetailsDao.create(user);
		log.info("create(user)-> | user : {} ", user);
		log.info("======== UserServiceImpl UserCreate Ended ======= ");
		return create;
	}

	@Override
	public List<UserInfoDto> getAll() {
		log.info("======== UserServiceImpl getALL Started ======= ");
		List<UserInfoDto> all = userDetailsDao.getAll();
		log.info("getall()-> | all : {}", all);
		log.info("======== UserServiceImpl getALL Ended ======= ");
		return all;
	}

	@Override
	public UserInfoDto getById(String id) throws RecordNotFound {
		log.info("======== UserServiceImpl getById Started ======= ");
		UserInfoDto byId = userDetailsDao.getById(id);
		log.info("getById(String)-> | id : {}", id);
		log.info("======== UserServiceImpl getById Ended======= ");
		return byId;
	}

	@Override
	public String deleteById(String id) throws RecordNotFound {
		log.info("======== UserServiceImpl deleteById Started ======= ");
		String deleteById = userDetailsDao.deleteById(id);
		log.info("deleteById(String)-> | id : {}", id);
		log.info("======== UserServiceImpl deleteById Ended======= ");
		return deleteById;
	}

	@Override
	public UserInfo update(UserInfo userDetails, String id) {
		log.info("======== UserServiceImpl Update Started ======= ");
		UserInfo update = userDetailsDao.update(userDetails, id);
		log.info("update(String)-> | id : {}", id);
		log.info("======== UserServiceImpl Update Ended ======= ");
		return update;
	}

	@Override
	public List<UserInfoDto> findByName(String name) throws RecordNotFound {
		log.info("======== UserServiceImpl findByName Started ======= ");
		List<UserInfoDto> findByName = userDetailsDao.findByName(name);
		log.info("findByname(String)-> | name : {}", name);
		log.info("======== UserServiceImpl findByName Ended======= ");
		return findByName;
	}

	@Override
	public UserProjectionEmail findByEmail(String email) throws RecordNotFound {
		log.info("======== UserServiceImpl findByEmail Started ======= ");
		UserProjectionEmail findByEmail = userDetailsDao.findByEmail(email);
		log.info("findByEmail(String)-> | email : {}", email);
		log.info("======== UserServiceImpl findByEmail Ended======= ");
		return findByEmail;
	}

	@Override
	public UserProjectionPhoneNo findByPhoneNo(String phoneNo) throws RecordNotFound {
		log.info("======== UserServiceImpl findByphoneNo Started ======= ");
		UserProjectionPhoneNo findByPhoneNo = userDetailsDao.findByPhoneNo(phoneNo);
		log.info("findByphoneNo(String)-> | phoneNo: {}", phoneNo);
		log.info("======== UserServiceImpl findByphoneNo Ended ======= ");

		return findByPhoneNo;
	}

	@Override
	public List<UserInfoDto> findByAddressCity(String city) throws RecordNotFound {
		log.info("======== UserServiceImpl findByphoneNo Started ======= ");
		List<UserInfoDto> findByAddressCity = userDetailsDao.findByAddressCity(city);
		log.info("findByADdressCity(String)-> | city: {}", city);
		log.info("======== UserServiceImpl findByphoneNo Started ======= ");

		return findByAddressCity;
	}

	@Override
	public List<UserInfoDto> findByAddressState(String state) throws RecordNotFound {
		log.info("======== UserServiceImpl findByphoneNo Started ======= ");
		List<UserInfoDto> findByAddressState = userDetailsDao.findByAddressState(state);
		log.info("findByAddressState(String)-> | state: {}", state);
		log.info("======== UserServiceImpl findByphoneNo Started ======= ");

		return findByAddressState;
	}

	@Override
	public void changePassword(String email, String password) throws RecordNotFound {
		userDetailsDao.changePassword(email, password);
		
	}
}
