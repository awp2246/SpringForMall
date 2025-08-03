package com.bob.springformall.service.impl;


import com.bob.springformall.dao.UserDao;
import com.bob.springformall.dto.UserRegisterRequest;
import com.bob.springformall.model.User;
import com.bob.springformall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
