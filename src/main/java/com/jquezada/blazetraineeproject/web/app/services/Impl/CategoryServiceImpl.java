package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Category;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.CategoryMapper;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ShopMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.CategoryRepository;
import com.jquezada.blazetraineeproject.web.app.services.CategoryService;
import com.jquezada.blazetraineeproject.web.app.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategories() {
        List<Category> list = new ArrayList<Category>();
        try{
            list = categoryRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category getCategoryById(String categoryId) {
        Category category = null;
        try {
            category = categoryRepository.findById(categoryId).orElse(null);
        } catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        try {
            Shop shop = null;
            if(category.getShopId() != null){
                shop =  shopService.getShopById(category.getShopId());
                category.setCompanyId(shop.getCompanyId());
            }
            categoryRepository.save(category);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        try {
            Category categoryDB = categoryRepository.findById(category.getId()).orElse(null);
            if(categoryDB != null){
                categoryDB.setName(category.getName());
                categoryDB.setDescription(category.getDescription());
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
