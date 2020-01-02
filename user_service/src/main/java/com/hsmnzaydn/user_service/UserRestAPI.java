package com.hsmnzaydn.user_service;


import com.hsmnzaydn.common.CommonResponse;
import com.hsmnzaydn.common.utility.Utility;
import com.hsmnzaydn.core_entity_lib.user.User;
import com.hsmnzaydn.user_service.service.UserService;
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
