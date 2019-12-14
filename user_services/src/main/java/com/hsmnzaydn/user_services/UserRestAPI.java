package com.hsmnzaydn.user_services;

import com.hsmnzaydn.core_api.CommonResponse;
import com.hsmnzaydn.core_api.utility.Utility;
import com.hsmnzaydn.user_services.model.UserDTO;
import com.hsmnzaydn.user_services.repository.User;
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
    public ResponseEntity<CommonResponse<User>> createUser(@RequestBody User user) {
        return ResponseEntity.ok(Utility.commonResponseFactory(userService.saveUser(user)));

    }

}
