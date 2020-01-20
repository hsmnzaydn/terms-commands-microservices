package com.hsmnzaydn.category.services;


import com.hsmnzaydn.category.error.CategoryNotFoundException;
import com.hsmnzaydn.category.models.CategoryDTO;
import com.hsmnzaydn.category.repository.CategoryRepository;
import com.hsmnzaydn.core_entity_lib.category.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServicesImpl implements CategoryServices {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryBean) {
        Category category = new Category();
        category.setCategoryTitle(categoryBean.getCategoryTitle());

        return new CategoryDTO(category.getId(),category.getCategoryTitle());
    }



    @Override
    public CategoryDTO getCategory(int categoryId)  {
        Category category=categoryRepository.findById(categoryId).get();
        return new CategoryDTO(category.getId(),category.getCategoryTitle());
    }

    @Override
    public List<CategoryDTO> getCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDTO(category.getId(),category.getCategoryTitle()))
                .collect(Collectors.toList());
    }
}
