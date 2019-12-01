package com.hsmnzaydn.command_services.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandRepository extends JpaRepository<CommandDao, Integer> {
    List<CommandDao> findByCategoryId(int categoryId);

}
