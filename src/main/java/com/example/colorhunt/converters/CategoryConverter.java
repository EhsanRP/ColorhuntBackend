package com.example.colorhunt.converters;

import com.example.colorhunt.controllers.DTO.CategoryDTO;
import com.example.colorhunt.domain.Category;

import java.util.List;

public interface CategoryConverter {
    Category entityMaker(CategoryDTO categoryDTO);

    CategoryDTO dtoMaker(Category category);

    List<CategoryDTO> dtoListMaker(List<Category> categories);
}
