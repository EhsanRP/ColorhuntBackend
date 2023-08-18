package com.example.colorhunt.validations;

import com.example.colorhunt.domain.Category;
import com.example.colorhunt.exceptions.ResourceNotFoundException;

import java.util.Optional;

public interface CategoryValidation {

    Category validateID(Long categoryId) throws ResourceNotFoundException;

    Category validateByField(Optional<Category> categoryOptional, String expectedParameterName, String expectedParameter);

}
