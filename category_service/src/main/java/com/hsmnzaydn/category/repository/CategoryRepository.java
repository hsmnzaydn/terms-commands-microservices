package com.hsmnzaydn.category.repository;

import com.hsmnzaydn.core_entity_lib.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
