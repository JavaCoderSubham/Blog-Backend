package com.blog.subscribe.service;

import java.util.List;

import com.blog.subscribe.entity.Subscribe;

public interface SubscribeService {
    List<Subscribe> getAllSubscribe();
    Subscribe create(Subscribe subscribe);
    String unSubscribe(String id);

    Subscribe findSubscribeByEmail(String email);
    
    Subscribe findSubscribeById(String id);
    
    void deleteSubscribeById(String id);

    void deleteSubscribeByEmail(String email);
    
    Subscribe findSubscribeByMobileNumber(String mobileNumber);
}
