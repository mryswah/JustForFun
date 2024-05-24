package com.memesapp.web.mapper;

import com.memesapp.web.dto.CategoriesDto;
import com.memesapp.web.model.Categories;

public class CategoriesMapper {
    public static Categories mapToCategories(CategoriesDto categoriesDto){
        Categories categories = Categories.builder()
                .id(categoriesDto.getId())
                .categoryName(categoriesDto.getCategoryName())
                .createdOn(categoriesDto.getCreatedOn())
                .updatedOn(categoriesDto.getUpdatedOn())
                .build();

        return categories;
    }

    public static CategoriesDto mapToCategoriesDto(Categories categories){
        CategoriesDto categoriesDto = CategoriesDto.builder()
                .id(categories.getId())
                .categoryName(categories.getCategoryName())
                .createdOn(categories.getCreatedOn())
                .updatedOn(categories.getUpdatedOn())
                .build();

        return categoriesDto;
    }
}
