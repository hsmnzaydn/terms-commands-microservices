package com.hsmzaydn.category_services;


import com.hsmnzaydn.core_api.CommonResponse;
import com.hsmzaydn.category_services.models.CategoryDTO;
import com.hsmzaydn.category_services.repository.Category;
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
    @HystrixCommand(fallbackMethod = "commonError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public ResponseEntity<CommonResponse<CategoryDTO>> addCategory(@RequestBody CategoryDTO categoryDTO) throws ExecutionException, InterruptedException {

        CommonResponse<CategoryDTO> categoryCommonResponse = new CommonResponse<>();
        categoryCommonResponse.setData(categoryServices.createCategory(categoryDTO));
        categoryCommonResponse.setCode(200);

        return ResponseEntity.ok(categoryCommonResponse);
    }

    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryServices.getCategories();
    }


    @GetMapping("/api/categories/{categoryId}")
    public CategoryDTO getCategory(@PathVariable("categoryId") int categoryId) throws ExecutionException, InterruptedException {
        return categoryServices.getCategory(categoryId);
    }


    private ResponseEntity<CommonResponse<CategoryDTO>> commonError(CategoryDTO categoryDTO) {
        CommonResponse<CategoryDTO> categoryCommonResponse = new CommonResponse<>();
        categoryCommonResponse.setCode(500);
        categoryCommonResponse.setMessage("Sunucu şuan yoğun");
        return ResponseEntity.status(500).body(categoryCommonResponse);
    }
}
