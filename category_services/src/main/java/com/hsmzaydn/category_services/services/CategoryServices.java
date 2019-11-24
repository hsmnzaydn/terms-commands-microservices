package com.hsmzaydn.category_services.services;


import com.hsmzaydn.category_services.aggregates.CategoryAggregate;
import com.hsmzaydn.category_services.models.CategoryBean;
import com.hsmzaydn.category_services.repository.CategoryDao;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CategoryServices {

    CategoryDao createCategory(CategoryBean categoryBean);

    CategoryDao getCategory(int categoryId) throws ExecutionException, InterruptedException;

    List<CategoryDao> getCategories();
}
