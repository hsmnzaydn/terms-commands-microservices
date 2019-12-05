package com.hsmnzaydn.user_services.service;

import com.hsmnzaydn.user_services.repository.UserDao;
import com.hsmnzaydn.user_services.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @Override
    public UserDao saveUser(UserDao userDao) {

        return null;
    }

    @Override
    public UserDao findUserByusername(String username) {
        return userRepository.findUserByUsername(username);
    }


}
