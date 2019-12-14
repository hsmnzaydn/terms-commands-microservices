package com.hsmnzaydn.user_services.service;

import com.hsmnzaydn.user_services.model.UserDTO;
import com.hsmnzaydn.user_services.repository.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    User findUserByusername(String username);
}
