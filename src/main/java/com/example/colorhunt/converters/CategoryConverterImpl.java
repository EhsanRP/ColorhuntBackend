package com.example.colorhunt.converters;

import com.example.colorhunt.controllers.DTO.CategoryDTO;
import com.example.colorhunt.domain.Category;
import com.example.colorhunt.repositories.CategoryRepository;
import com.example.colorhunt.validations.CategoryValidation;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Value
@RequiredArgsConstructor
@Service
public class CategoryConverterImpl implements CategoryConverter {

    CategoryValidation categoryValidation;
    CategoryRepository categoryRepository;

    @Override
    public Category entityMaker(CategoryDTO categoryDTO) {
        var category = new Category();
        category.setName(categoryDTO.getName());

        if (categoryDTO.getId() != null) {
            var existingCategory = categoryValidation.validateID(categoryDTO.getId());
            category.setId(existingCategory.getId());
            category.setPalettes(existingCategory.getPalettes());
        }

        return category;
    }

    @Override
    public CategoryDTO dtoMaker(Category category) {
        return new CategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> dtoListMaker(List<Category> categories) {
        var list = new ArrayList<CategoryDTO>();

        categories.forEach(category -> list.add(dtoMaker(category)));

        return list;
    }
}
