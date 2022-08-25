package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.jquezada.blazetraineeproject.web.app.domain.mapper.CategoryMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CategoryResponse;
import com.jquezada.blazetraineeproject.web.app.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/categories")
public class CategoryResource {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryResponse> getCategories(){
        return categoryMapper.dtoListToResponseList(categoryService.getCategories());
    }

    @PostMapping
    public void saveCategory(@RequestBody CategoryAddRequest categoryAddRequest){
        categoryService.saveCategory(categoryMapper.addRequestToDto(categoryAddRequest));
    }

    @PutMapping
    public void updateCategory(@RequestBody CategoryUpdateRequest categoryUpdateRequest){
        categoryService.updateCategory(categoryMapper.updateRequestToDto(categoryUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable String id){
        categoryService.deleteCategoryById(id);
    }
}
