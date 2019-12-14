package com.hsmzaydn.category_services.services;


import com.hsmzaydn.category_services.models.CategoryDTO;
import com.hsmzaydn.category_services.repository.Category;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CategoryServices {

    CategoryDTO createCategory(CategoryDTO categoryBean);

    CategoryDTO getCategory(int categoryId) throws ExecutionException, InterruptedException;

    List<CategoryDTO> getCategories();
}
