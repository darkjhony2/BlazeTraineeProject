package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.dto.ProductDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Product;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ProductMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.ProductRepository;
import com.jquezada.blazetraineeproject.web.app.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getProducts() {
        List<Product> list = new ArrayList<Product>();
        List<ProductDto> listDto = new ArrayList<>();
        try {
            list = productRepository.findAll();
            listDto = productMapper.entitiesToDtoList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        try {
            productRepository.save(productMapper.dtoToEntity(productDto));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        try {
            Product productDB = productRepository.findById(productDto.getId()).orElse(null);
            if(productDB != null){
                productDB.setName(productDto.getName());
                productDB.setDescription(productDto.getDescription());
                productRepository.save(productDB);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProductById(String productId) {
        try{
            Product product = productRepository.findById(productId).orElse(null);
            if(product != null){
                product.setDeleted(true);
                productRepository.save(product);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
