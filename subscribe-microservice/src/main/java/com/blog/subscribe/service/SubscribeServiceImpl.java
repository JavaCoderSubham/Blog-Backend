package com.blog.subscribe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.subscribe.dao.SubscribeDao;
import com.blog.subscribe.entity.Subscribe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscribeDao subscribeDao;
    
    //Get All Subscribers
    @Override
    public List<Subscribe> getAllSubscribe() {
        log.info("getAll() -> | ");
        List<Subscribe> all = subscribeDao.getAllSubscribe();
        log.info("getAll() -> | List Subscribe : {}",all);
        return all;
    }

    //Create Subscriber
    @Override
    public Subscribe create(Subscribe subscribe) {
        log.info("create(Subscribe) -> | Subscribe : {}",subscribe);
        Subscribe getSave = subscribeDao.create(subscribe);
        log.info("create(Subscribe) -> | After execute Dao Create : {}",getSave);
        return getSave;
    }

    //Unsubscribe By Id
    @Override
    public String unSubscribeById(String id) {
        log.info("unsubscribe() -> | Unsubscribing Subscribe : {}");
        subscribeDao.unSubscribeById(id);
        log.info("unsubscribe() -> | Subscribe Unsubscribed : {}");
        return "Successfully unsubscribed";
    }
    
    //Unsubscribe By Email
    @Override
    public String unSubscribeByEmail(String email) {
        log.info("unsubscribeByEmail() -> | Unsubscribing Subscribe : {} ", email);
        subscribeDao.unSubscribeByEmail(email);
        log.info("unsubscribeByEmail() -> | Subscribe Unsubscribed : {} ", email);
        return "Successfully unsubscribed";
    }
    
    //Unsubscribe By Mobile Number
    @Override
    public String unSubscribeByMobileNumber(String mobileNumber) {
        log.info("unsubscribeByMobileNumber() -> | Unsubscribing Subscribe : {} ", mobileNumber);
        subscribeDao.unSubscribeByMobileNumber(mobileNumber);
        log.info("unsubscribeByMobileNumber() -> | Subscribe Unsubscribed : {} ", mobileNumber);
        return "Successfully unsubscribed";
    }

    //Find subscribe By Email
    @Override
    public Subscribe findSubscribeByEmail(String email) {
        log.info("findSubscribeByEmail() -> | ");
        Subscribe subscribe = subscribeDao.findSubscribeByEmail(email);
        log.info("findSubscribeByEmail() -> | Subscribe : {}", subscribe);
        return subscribe;
    }

    //Delete Subscribe By Id
    @Override
    public void deleteSubscribeById(String id) {
        log.info("subscribeDeleteById(String) -> | Id : {}",id);
        subscribeDao.deleteSubscribeById(id);
        log.info("deleteSubscribeById(String) -> | Id : {} | Deleted",id);
    }
    
    //Delete Subscribe By Email
    @Override
    public void deleteSubscribeByEmail(String email) {
        log.info("deleteSubscribeByEmail(String) -> | Email : {}",email);
        subscribeDao.deleteSubscribeByEmail(email);
        log.info("deleteSubscribeByEmail(String) -> | Email : {} | Deleted",email);
    }
      
    //Find Subscribe By Id
    @Override
    public Subscribe findSubscribeById(String id) {
        log.info("findSubscribeById() -> | ");
        Subscribe subscribe = subscribeDao.findSubscribeById(id);
        log.info("findSubscribeById() -> | Subscribe : {}", subscribe);
        return subscribe;
    }

    //Find Subscribe By Mobile Number
	@Override
	public Subscribe findSubscribeByMobileNumber(String mobileNumber) {
		log.info("findSubscribeByMobileNumber) -> | ");
        Subscribe subscribe = subscribeDao.findSubscribeByMobileNumber(mobileNumber);
        log.info("findSubscribeByMobileNumber() -> | Subscribe : {}", subscribe);
        return subscribe;
	}
}
