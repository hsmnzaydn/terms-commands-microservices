package com.hsmnzaydn.user_service.service;

import com.hsmnzaydn.core_entity_lib.user.User;

import com.hsmnzaydn.user_service.repository.UserRepository;
import com.hsmnzaydn.user_service.utility.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public User saveUser(User user) {

        if(findUserByusername(user.getUsername()) == null){
            userRepository.save(user);
            loadUserByUsername(user.getUsername());
            User user1 =findUserByusername(user.getUsername());
            user1.setAuthorizationKey(jwtTokenUtil.generateToken(loadUserByUsername(user.getUsername())));
            return userRepository.save(user1);
        }else {
            throw new UsernameNotFoundException(user.getUsername());
        }

    }

    @Override
    public User findUserByusername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User applicationUser = userRepository.findUserByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());

    }
}
