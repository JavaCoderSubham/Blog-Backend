package com.blog.dao.userInfo;

import com.blog.entity.UserInfo;

public interface UserInfoDao {
    UserInfo getAll();
    UserInfo getUserInfo(String id);
    UserInfo findByMobileNumber(String number);

}
