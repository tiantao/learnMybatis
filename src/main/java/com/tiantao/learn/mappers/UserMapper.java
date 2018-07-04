package com.tiantao.learn.mappers;

import com.tiantao.learn.pojo.User;

/**
 * Created by tiantao on 2018/6/4.
 */
public interface UserMapper {
    public User selectUser(Long id);

    public void updateUserName(User user);
}
