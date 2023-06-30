package com.blog.subscribe.dao;

import java.util.List;

import com.blog.subscribe.entity.Subscribe;

public interface SubscribeDao {
    List<Subscribe> getAllSubscribe();
    Subscribe create(Subscribe subscribe);
    void unSubscribe(String id);

    Subscribe findSubscribeByEmail(String email);
    
    Subscribe findSubscribeByMobileNumber(String mobileNumber);
    
    Subscribe findSubscribeById(String id);

    void deleteSubscribeById(String id);
    
    void deleteSubscribeByEmail(String email);
}
