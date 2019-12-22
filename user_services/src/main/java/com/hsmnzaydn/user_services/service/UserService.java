package com.hsmnzaydn.user_services.service;

import com.hsmnzaydn.core_entity_lib.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    User findUserByusername(String username);
}
