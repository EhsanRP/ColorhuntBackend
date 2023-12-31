package com.example.colorhunt.validations;

import com.example.colorhunt.domain.Category;
import com.example.colorhunt.exceptions.ResourceNotFoundException;
import com.example.colorhunt.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Value
@RequiredArgsConstructor
@Service
public class CategoryValidationImpl implements CategoryValidation {

    CategoryRepository categoryRepository;

    @Override
    public Category validateID(Long categoryId) throws ResourceNotFoundException {
        var categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isEmpty())
            throw new ResourceNotFoundException("Category with id " + categoryId + " Not found");

        return categoryOptional.get();
    }

    @Override
    public Category validateByField(Optional<Category> categoryOptional, String expectedParameterName, String expectedParameter) {

        if (categoryOptional.isEmpty())
            throw new ResourceNotFoundException("Category with " + expectedParameterName + " " + expectedParameter + " not found");

        return categoryOptional.get();
    }
}
