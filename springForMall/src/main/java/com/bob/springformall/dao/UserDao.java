package com.bob.springformall.dao;

import com.bob.springformall.dto.UserRegisterRequest;
import com.bob.springformall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
