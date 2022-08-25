package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    List<CategoryDto> getCategories();
    void saveCategory(CategoryDto categoryDto);
    void updateCategory(CategoryDto categoryDto);
    void deleteCategoryById(String categoryId);
}
