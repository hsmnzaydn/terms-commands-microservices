package com.hsmzaydn.category_services.services;


import com.hsmnzaydn.core_entity_lib.category.Category;
import com.hsmzaydn.category_services.models.CategoryDTO;
import com.hsmzaydn.category_services.repository.CategoryRepository;
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
        //  commandGateway.send(new CategoryCreatedCommand(categoryBean.getCategoryId(), categoryBean.getCategoryTitle()));
        // kafkaTemplate.send("test","aaa");
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
