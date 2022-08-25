package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> getProducts();
    void saveProduct(ProductDto productDto);
    void updateProduct(ProductDto productDto);
    void deleteProductById(String productId);
}
