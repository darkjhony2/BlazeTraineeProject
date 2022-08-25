package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.dto.ProductDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Product;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product dtoToEntity(ProductDto productDto);
    ProductDto entityToDto(Product product);
    ProductResponse dtoToResponse(ProductDto productDto);
    List<Product> dtoListToEntities(List<ProductDto> productDtoList);
    List<ProductDto> entitiesToDtoList(List<Product> productList);
    List<ProductResponse> dtoListToResponseList(List<ProductDto> productDtoList);
    ProductDto addRequestToDto(ProductAddRequest productAddRequest);
    ProductDto updateRequestToDto(ProductUpdateRequest productUpdateRequest);
}
