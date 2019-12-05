package com.hsmzaydn.category_services;


import com.hsmzaydn.category_services.models.CategoryDTO;
import com.hsmzaydn.category_services.repository.Category;
import com.hsmzaydn.category_services.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    CategoryServices categoryServices;

    @PostMapping
    public Category addCategory(@RequestBody CategoryDTO categoryBean) throws ExecutionException, InterruptedException {
        return categoryServices.createCategory(categoryBean);
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryServices.getCategories();
    }


    @GetMapping("/api/categories/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") int categoryId) throws ExecutionException, InterruptedException {
        return categoryServices.getCategory(categoryId);
    }


}
