package com.hsmnzaydn.user_services.service;

import com.hsmnzaydn.user_services.repository.UserDao;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDao saveUser(UserDao userDao);
    UserDao findUserByusername(String username);
}
