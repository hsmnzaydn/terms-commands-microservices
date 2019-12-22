package com.hsmnzaydn.user_services.repository;

import com.hsmnzaydn.core_entity_lib.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {

    User findUserByUsername(String username);

}
