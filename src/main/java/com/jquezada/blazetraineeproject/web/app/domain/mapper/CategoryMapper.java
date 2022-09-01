package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Category;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CategoryUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category addRequestToEntity(CategoryAddRequest categoryAddRequest);
    Category updateRequestToEntity(CategoryUpdateRequest categoryUpdateRequest);
    CategoryResponse entityToResponse(Category category);
    List<Category> addRequestsToEntities(List<CategoryAddRequest> categoryAddRequests);
    List<Category> updateRequestsToEntities(List<CategoryUpdateRequest> updateRequests);
    List<CategoryResponse> entitiesToResponses(List<Category> categories);
}
