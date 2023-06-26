package com.blog.dao.subscribe;

import com.blog.entity.Subscribe;

import java.util.List;

public interface SubscribeDao {
    List<Subscribe> getAllSubscribe();
    Subscribe create(Subscribe subscribe);
    void UnSubscribe(String id);

}
