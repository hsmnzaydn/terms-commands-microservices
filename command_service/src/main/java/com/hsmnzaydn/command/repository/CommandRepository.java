package com.hsmnzaydn.command.repository;


import com.hsmnzaydn.core_entity_lib.command.Command;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Integer> {
    List<Command> findByCategoryId(int categoryId);

}
