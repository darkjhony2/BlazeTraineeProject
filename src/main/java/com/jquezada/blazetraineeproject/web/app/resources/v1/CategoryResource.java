package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jquezada.blazetraineeproject.web.app.config.CoreModule;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.CategoryMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CategoryResponse;
import com.jquezada.blazetraineeproject.web.app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/categories")
public class CategoryResource {

//    @Inject
//    Injector injector;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    public List<CategoryResponse> getCategories(){
        //CategoryService categoryService = injector.getInstance(CategoryService.class);
        return categoryMapper.entitiesToResponses(categoryService.getCategories());
    }

    @PostMapping
    public void saveCategory(@RequestBody CategoryAddRequest categoryAddRequest){
        //CategoryService categoryService = injector.getInstance(CategoryService.class);
        categoryService.saveCategory(categoryMapper.addRequestToEntity(categoryAddRequest));
    }

    @PutMapping
    public void updateCategory(@RequestBody CategoryUpdateRequest categoryUpdateRequest){
        //CategoryService categoryService = injector.getInstance(CategoryService.class);
        categoryService.updateCategory(categoryMapper.updateRequestToEntity(categoryUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable String id){
        //CategoryService categoryService = injector.getInstance(CategoryService.class);
        categoryService.deleteCategoryById(id);
    }
}
