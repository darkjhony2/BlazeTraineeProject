package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.dto.CategoryDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Category;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category dtoToEntity(CategoryDto categoryDto);
    CategoryDto entityToDto(Category category);
    CategoryResponse dtoToResponse(CategoryDto categoryDto);
    List<Category> dtoListToEntities(List<CategoryDto> categoryDtoList);
    List<CategoryDto> entitiesToDtoList(List<Category> categoryList);
    List<CategoryResponse> dtoListToResponseList(List<CategoryDto> categoryDtoList);
    CategoryDto addRequestToDto(CategoryAddRequest categoryAddRequest);
    CategoryDto updateRequestToDto(CategoryUpdateRequest categoryUpdateRequest);
}
