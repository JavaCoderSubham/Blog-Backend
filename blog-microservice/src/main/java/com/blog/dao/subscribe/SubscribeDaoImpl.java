package com.blog.dao.subscribe;

import com.blog.entity.Subscribe;
import com.blog.repository.SubScribeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Component
public class SubscribeDaoImpl implements SubscribeDao {

    private final SubScribeRepository repository;

    public SubscribeDaoImpl(SubScribeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Subscribe> getAllSubscribe() {
//        TODO
        return null;
    }

    @Override
    public Subscribe create(Subscribe subscribe) {
//        TODO
        return null;
    }

    @Override
    public void UnSubscribe(String id) {
//        TODO
    }

}




