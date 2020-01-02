package com.hsmnzaydn.category.services;



import com.hsmnzaydn.category.models.CategoryDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CategoryServices {

    CategoryDTO createCategory(CategoryDTO categoryBean);

    CategoryDTO getCategory(int categoryId) throws ExecutionException, InterruptedException;

    List<CategoryDTO> getCategories();
}
