package com.blog.service;

import com.blog.entity.Subscribe;

import java.util.List;

public interface SubscribeService {
    List<Subscribe> getAllSubscribe();
    Subscribe create(Subscribe subscribe);
    String unSubscribe(String id);

    Subscribe findSubscribeByEmail(String email);

    void subscribeDeleteById(String id);
}
