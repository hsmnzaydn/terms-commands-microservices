package com.hsmnzaydn.user_services.service;

import com.hsmnzaydn.user_services.repository.UserDao;
import com.hsmnzaydn.user_services.repository.UserRepository;
import com.hsmnzaydn.user_services.utility.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
    public UserDao saveUser(UserDao userDao) {

        if(findUserByusername(userDao.getUsername()) == null){
            userRepository.save(userDao);
            loadUserByUsername(userDao.getUsername());
            UserDao userDao1=findUserByusername(userDao.getUsername());
            userDao1.setAuthorizationKey(jwtTokenUtil.generateToken(loadUserByUsername(userDao.getUsername())));
            return userRepository.save(userDao1);
        }else {
            throw new UsernameNotFoundException(userDao.getUsername());
        }

    }

    @Override
    public UserDao findUserByusername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao applicationUserDao = userRepository.findUserByUsername(username);
        if (applicationUserDao == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUserDao.getUsername(), applicationUserDao.getPassword(), emptyList());

    }
}
