package com.bob.springformall.service;


import com.bob.springformall.dto.UserRegisterRequest;
import com.bob.springformall.model.User;
import org.springframework.stereotype.Controller;

@Controller
public interface UserService {

   Integer register(UserRegisterRequest userRegisterRequest);

   User getUserById(Integer userId);
}
