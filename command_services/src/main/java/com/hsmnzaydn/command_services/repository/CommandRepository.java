package com.hsmnzaydn.command_services.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<CommandDao, Integer> {
}
