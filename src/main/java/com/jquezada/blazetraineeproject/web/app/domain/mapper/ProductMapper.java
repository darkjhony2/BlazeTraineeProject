package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Product;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product addRequestToEntity(ProductAddRequest productAddRequest);
    Product updateRequestToEntity(ProductUpdateRequest productUpdateRequest);
    ProductResponse entityToResponse(Product product);
    List<Product> addRequestsToEntities(List<ProductAddRequest> productAddRequests);
    List<Product> updateRequestsToEntities(List<ProductUpdateRequest> productUpdateRequests);
    List<ProductResponse> entitiesToResponses(List<Product> products);
}
