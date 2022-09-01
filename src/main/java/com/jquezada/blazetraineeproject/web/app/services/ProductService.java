package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    void saveProduct(Product productDto);
    void updateProduct(Product productDto);
    void deleteProductById(String productId);
}
