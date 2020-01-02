package com.hsmnzaydn.category.models;

import lombok.Data;

@Data
public class CategoryDTO {
    private int categoryId;
    private String categoryTitle;

    public CategoryDTO(int categoryId, String categoryTitle) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
    }
}
