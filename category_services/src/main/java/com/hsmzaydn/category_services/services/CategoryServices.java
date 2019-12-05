package com.hsmzaydn.category_services.services;


import com.hsmzaydn.category_services.models.CategoryDTO;
import com.hsmzaydn.category_services.repository.Category;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CategoryServices {

    Category createCategory(CategoryDTO categoryBean);

    Category getCategory(int categoryId) throws ExecutionException, InterruptedException;

    List<Category> getCategories();
}
