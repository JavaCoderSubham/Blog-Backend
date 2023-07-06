package com.blog.subscribe.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.blog.subscribe.entity.Subscribe;
import com.blog.subscribe.exceptions.EmailOrMobileAlreadyExistException;
import com.blog.subscribe.exceptions.SubscriberNotFoundException;
import com.blog.subscribe.repository.SubScribeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SubscribeDaoImpl implements SubscribeDao {

    private final SubScribeRepository repository;

    public SubscribeDaoImpl(SubScribeRepository repository) {
        this.repository = repository;
    }

    //Get All Subscribers
    @Override
    public List<Subscribe> getAllSubscribe() {
        log.info("getAllSubscribe() -> | ");
        List<Subscribe> all = repository.findAll();
        log.info("getAllSubscribe() -> | List Subscribe : {}", all);

        return all;
    }

    //Create a Subscriber
    @Override
    public Subscribe create(Subscribe subscribe) {
        log.info("create(Subscribe) -> | Request Subscribe : {}",subscribe);
        subscribe.setActiveSubscribe(true);
        subscribe.setId(UUID.randomUUID().toString());
        log.info("create(Subscribe) -> | After Set Id Subscribe : {}",subscribe);
        if (emailOrPhoneNumberAlreadyExist(subscribe)) {
            throw new EmailOrMobileAlreadyExistException();
        }
        Subscribe save = repository.save(subscribe);
        log.info("create(Subscribe) -> | After Save Subscribe : {}",subscribe);
        return save;
    }
    
    //Unsubscribe By Id
    @Override
    public void unSubscribeById(String subscribeId) {
        Optional<Subscribe> optionalSubscribe = repository.findById(subscribeId);
        if (optionalSubscribe.isPresent()) {
            Subscribe subscribe = optionalSubscribe.get();
            log.info("unsubscribeById() -> | Unsubscribing Subscribe : {}", subscribe);
            subscribe.setActiveSubscribe(false);
            repository.save(subscribe);
            log.info("unsubscribeById() -> | Subscribe Unsubscribed : {}", subscribe);
//            return "You have Unsubscribed from the services with id " + subscribeId + ". Hence you are unable to recieve the updates";
        } else {
            log.error("unsubscribeById() -> | Subscribe not found for id: {}", subscribeId);
            // throw an exception or handle the case where the subscribeId is not found
            throw new SubscriberNotFoundException();
        }
    }
    
    //Unsubcribe By Email
    @Override
    public void unSubscribeByEmail(String email) {
        Optional<Subscribe> optionalSubscribe = repository.findSubscribeByEmail(email);
        if (optionalSubscribe.isPresent()) {
            Subscribe subscribe = optionalSubscribe.get();
            log.info("unsubscribeByEmail() -> | Unsubscribing Subscribe : {}", subscribe);
            subscribe.setActiveSubscribe(false);
            repository.save(subscribe);
            log.info("unsubscribeByEmail() -> | Subscribe Unsubscribed : {}", subscribe);
//            return "You have Unsubscribed from the services with id " + subscribeId + ". Hence you are unable to recieve the updates";
        } else {
            log.error("unsubscribeByEmail() -> | Subscribe not found for email: {}", email);
            // throw an exception or handle the case where the subscribeId is not found
            throw new SubscriberNotFoundException();
        }
    }
    
    //Unsubscribe by Mobile Number
    @Override
    public void unSubscribeByMobileNumber(String mobileNumber) {
        Optional<Subscribe> optionalSubscribe = repository.findSubscribeByMobileNumber(mobileNumber);
        if (optionalSubscribe.isPresent()) {
            Subscribe subscribe = optionalSubscribe.get();
            log.info("unsubscribeByMobileNumber() -> | Unsubscribing Subscribe : {}", subscribe);
            subscribe.setActiveSubscribe(false);
            repository.save(subscribe);
            log.info("unsubscribeByMobileNumber() -> | Subscribe Unsubscribed : {}", subscribe);
//            return "You have Unsubscribed from the services with id " + subscribeId + ". Hence you are unable to recieve the updates";
        } else {
            log.error("unsubscribeByMobileNumber() -> | Subscribe not found for id: {}", mobileNumber);
            // throw an exception or handle the case where the subscribeId is not found
            throw new SubscriberNotFoundException();
        }
    }

    //Find Subscribe By Email
    @Override
    public Subscribe findSubscribeByEmail(String email) {
        log.info("findSubscribeByEmail() -> | {}", email);
        Subscribe optionalSubscribe = repository.findSubscribeByEmail(email).orElseThrow(() -> new SubscriberNotFoundException());
        log.info("findSubscribeByEmail() -> | Subscribe : {}", optionalSubscribe);
        return optionalSubscribe;
    }

    //Delete Subscribe By Id
    @Override
    public void deleteSubscribeById(String id) {
    	if(repository.findById(id).isPresent()) {
    		log.info("delete(String) -> | Id : {}",id);
            repository.deleteById(id);
            log.info("delete(String) -> | Deleted... ID : {}",id);
    	}
    	else {
    		throw new SubscriberNotFoundException();
    	}
    }

    //Find Subscribe By Id
	@Override
	public Subscribe findSubscribeById(String id) {
		log.info("findSubscribeById() -> | ", id);
        Subscribe optionalSubscribe = repository.findById(id).orElseThrow(() -> new SubscriberNotFoundException());
        log.info("findSubscribeById() -> | Subscribe : {}", optionalSubscribe);
        return optionalSubscribe;
	}

	//Delete Subscribe By Email
	@Override
	public void deleteSubscribeByEmail(String email) {	
		log.info("delete(String) -> | Email : {}",email);
        repository.deleteSubscribeByEmail(email);
        log.info("delete(String) -> | Deleted... Email : {}",email);
	}

	//Find Subscribe By Mobile Number
	@Override
	public Subscribe findSubscribeByMobileNumber(String mobileNumber) {
		log.info("findSubscribeByMobileNumber() -> | ", mobileNumber);
        Subscribe optionalSubscribe = repository.findSubscribeByMobileNumber(mobileNumber).orElseThrow(() -> new SubscriberNotFoundException());
        log.info("findSubscribeByMobileNumber() -> | Subscribe : {}", optionalSubscribe);
        return optionalSubscribe;
	}

	@Override
	public boolean emailOrPhoneNumberAlreadyExist(Subscribe subscribe) {
		return repository.findSubscribeByEmail(subscribe.getEmail()).isPresent() ||
	            repository.findSubscribeByMobileNumber(subscribe.getMobileNumber()).isPresent();
	}
}




