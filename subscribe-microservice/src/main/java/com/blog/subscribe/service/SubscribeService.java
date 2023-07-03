package com.blog.subscribe.service;

import java.util.List;

import com.blog.subscribe.entity.Subscribe;

public interface SubscribeService {
    List<Subscribe> getAllSubscribe();
    Subscribe create(Subscribe subscribe);
    String unSubscribeById(String id);
    
    String unSubscribeByEmail(String email);
    
    String unSubscribeByMobileNumber(String mobileNumber);

    Subscribe findSubscribeByEmail(String email);
    
    Subscribe findSubscribeById(String id);
    
    void deleteSubscribeById(String id);

    void deleteSubscribeByEmail(String email);
    
    Subscribe findSubscribeByMobileNumber(String mobileNumber);
}
