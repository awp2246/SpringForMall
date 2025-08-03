package com.bob.springformall.service.impl;


import com.bob.springformall.dao.UserDao;
import com.bob.springformall.dao.impl.UserdaoImpl;
import com.bob.springformall.dto.UserLoginRequest;
import com.bob.springformall.dto.UserRegisterRequest;
import com.bob.springformall.model.User;
import com.bob.springformall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserdaoImpl userdaoImpl;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (user != null) {
            log.warn("email {} already in use", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {

        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        if (user != null) {
            if (user.getPassword().equals(userLoginRequest.getPassword())) {
                return user;
            } else {
                log.warn("password {} does not match", userLoginRequest.getPassword());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } else {
            log.warn("email {} not found", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
