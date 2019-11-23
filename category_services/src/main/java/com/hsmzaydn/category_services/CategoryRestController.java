package com.hsmzaydn.category_services;


import com.hsmzaydn.category_services.models.CategoryBean;
import com.hsmzaydn.category_services.repository.CategoryDao;
import com.hsmzaydn.category_services.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    CategoryServices categoryServices;

    @PostMapping
    public CategoryDao addCategory(@RequestBody CategoryBean categoryBean) throws ExecutionException, InterruptedException {
        return categoryServices.createCategory(categoryBean);
    }


    @GetMapping("/api/categories/{categoryId}")
    public CategoryDao getCategory(@PathVariable("categoryId") int categoryId) throws ExecutionException, InterruptedException {
        return categoryServices.getCategory(categoryId);
    }


}
