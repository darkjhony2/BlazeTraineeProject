package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();
    Category getCategoryById(String categoryId);
    void saveCategory(Category category);
    void updateCategory(Category category);
    void deleteCategoryById(String categoryId);
}
