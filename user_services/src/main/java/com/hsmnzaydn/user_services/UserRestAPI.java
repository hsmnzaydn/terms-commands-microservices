package com.hsmnzaydn.user_services;

import com.hsmnzaydn.user_services.repository.UserDao;
import com.hsmnzaydn.user_services.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
@RequiredArgsConstructor
public class UserRestAPI {

    private final UserService userService;



    @PostMapping("register")
    public ResponseEntity<UserDao> createUser(@RequestBody UserDao userDao) {

        return ResponseEntity.ok(userService.saveUser(userDao));

    }

}
