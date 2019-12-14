package com.hsmzaydn.category_services;


import com.hsmnzaydn.core_api.CommonResponse;
import com.hsmnzaydn.core_api.configuration.*;
import com.hsmnzaydn.core_api.utility.Utility;
import com.hsmzaydn.category_services.models.CategoryDTO;
import com.hsmzaydn.category_services.services.CategoryServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    CategoryServices categoryServices;

    @PostMapping
    @HystrixCommand(fallbackMethod = "addCategoryError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HystrixConfiguration.TIME_OUT)
    })
    public ResponseEntity<CommonResponse<CategoryDTO>> addCategory(@RequestBody CategoryDTO categoryDTO) throws ExecutionException, InterruptedException {

        return ResponseEntity.ok(Utility.commonResponseFactory(categoryServices.createCategory(categoryDTO)));
    }

    @HystrixCommand(fallbackMethod = "getCategoriesError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HystrixConfiguration.TIME_OUT)
    })
    @GetMapping
    public ResponseEntity<CommonResponse<List<CategoryDTO>>> getCategories() {
        return ResponseEntity.ok(Utility.commonResponseFactory(categoryServices.getCategories()));
    }


    @HystrixCommand(fallbackMethod = "getCategoryError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HystrixConfiguration.TIME_OUT)
    })
    @GetMapping("/api/categories/{categoryId}")
    public ResponseEntity<CommonResponse<CategoryDTO>> getCategory(@PathVariable("categoryId") int categoryId) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok().body(Utility.commonResponseFactory(categoryServices.getCategory(categoryId)));
    }


    private ResponseEntity<CommonResponse<List<CategoryDTO>>> getCategoriesError(){
        return ResponseEntity.status(500).body(Utility.commonErrorResponseFactory());
    }

    private ResponseEntity<CommonResponse<CategoryDTO>> addCategoryError(CategoryDTO categoryDTO) {
        return ResponseEntity.status(500).body(Utility.commonErrorResponseFactory());
    }

    private ResponseEntity<CommonResponse<CategoryDTO>> getCategoryError(CategoryDTO categoryDTO) {
        return ResponseEntity.status(500).body(Utility.commonErrorResponseFactory());
    }


}
