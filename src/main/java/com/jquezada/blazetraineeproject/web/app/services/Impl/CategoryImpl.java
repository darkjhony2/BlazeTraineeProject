package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.dto.CategoryDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Category;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.CategoryMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.CategoryRepository;
import com.jquezada.blazetraineeproject.web.app.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> list = new ArrayList<Category>();
        List<CategoryDto> listDto = new ArrayList<>();
        try{
            list = categoryRepository.findAll();
            listDto = categoryMapper.entitiesToDtoList(list);
        } catch (Exception e){
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public void saveCategory(CategoryDto categoryDto) {
        try {
            categoryRepository.save(categoryMapper.dtoToEntity(categoryDto));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(CategoryDto categoryDto) {
        try {
            Category categoryDB = categoryRepository.findById(categoryDto.getId()).orElse(null);
            if(categoryDB != null){
                categoryDB.setName(categoryDto.getName());
                categoryDB.setDescription(categoryDto.getDescription());
                categoryRepository.save(categoryDB);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategoryById(String categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).orElse(null);
            if(category != null){
                category.setDeleted(true);
                categoryRepository.save(category);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
