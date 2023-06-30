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

    @Override
    public List<Subscribe> getAllSubscribe() {
        log.info("getAllSubscribe() -> | ");
        List<Subscribe> all = repository.findAll();
        log.info("getAllSubscribe() -> | List Subscribe : {}", all);

        return all;
    }

    @Override
    public Subscribe create(Subscribe subscribe) {
        log.info("create(Subscribe) -> | Request Subscribe : {}",subscribe);
        subscribe.setActiveSubscribe(true);
        subscribe.setId(UUID.randomUUID().toString());
        log.info("create(Subscribe) -> | After Set Id Subscribe : {}",subscribe);
        if (repository.findSubscribeByEmail(subscribe.getEmail()).isPresent() ||
                repository.findSubscribeByMobileNumber(subscribe.getMobileNumber()).isPresent()) {
            throw new EmailOrMobileAlreadyExistException();
        }
        Subscribe save = repository.save(subscribe);
        log.info("create(Subscribe) -> | After Save Subscribe : {}",subscribe);
        return save;
    }

    @Override
    public void unSubscribe(String subscribeId) {
        Optional<Subscribe> optionalSubscribe = repository.findById(subscribeId);
        if (optionalSubscribe.isPresent()) {
            Subscribe subscribe = optionalSubscribe.get();
            log.info("unsubscribe() -> | Unsubscribing Subscribe : {}", subscribe);
            subscribe.setActiveSubscribe(false);
            repository.save(subscribe);
            log.info("unsubscribe() -> | Subscribe Unsubscribed : {}", subscribe);
//            return "You have Unsubscribed from the services with id " + subscribeId + ". Hence you are unable to recieve the updates";
        } else {
            log.error("unsubscribe() -> | Subscribe not found for id: {}", subscribeId);
            // throw an exception or handle the case where the subscribeId is not found
            throw new SubscriberNotFoundException();
        }
    }

    @Override
    public Subscribe findSubscribeByEmail(String email) {
        log.info("findSubscribeByEmail() -> | ");
        Subscribe optionalSubscribe = repository.findSubscribeByEmail(email).orElseThrow(() -> new SubscriberNotFoundException());
        log.info("findSubscribeByEmail() -> | Subscribe : {}", optionalSubscribe);
        return optionalSubscribe;
    }

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

	@Override
	public Subscribe findSubscribeById(String id) {
		log.info("findSubscribeById() -> | ");
        Subscribe optionalSubscribe = repository.findById(id).orElseThrow(() -> new SubscriberNotFoundException());
        log.info("findSubscribeById() -> | Subscribe : {}", optionalSubscribe);
        return optionalSubscribe;
	}

	@Override
	public void deleteSubscribeByEmail(String email) {	
		log.info("delete(String) -> | Email : {}",email);
        repository.deleteSubscribeByEmail(email);
        log.info("delete(String) -> | Deleted... Email : {}",email);
	}

	@Override
	public Subscribe findSubscribeByMobileNumber(String mobileNumber) {
		log.info("findSubscribeByMobileNumber() -> | ");
        Subscribe optionalSubscribe = repository.findSubscribeByMobileNumber(mobileNumber).orElseThrow(() -> new SubscriberNotFoundException());
        log.info("findSubscribeByMobileNumber() -> | Subscribe : {}", optionalSubscribe);
        return optionalSubscribe;
	}

}




