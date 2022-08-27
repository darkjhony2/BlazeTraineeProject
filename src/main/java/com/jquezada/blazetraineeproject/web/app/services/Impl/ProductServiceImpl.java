package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.google.inject.Inject;
import com.jquezada.blazetraineeproject.web.app.domain.dto.ProductDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Product;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ProductMapper;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ShopMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.ProductRepository;
import com.jquezada.blazetraineeproject.web.app.services.ProductService;
import com.jquezada.blazetraineeproject.web.app.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ShopMapper shopMapper;

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
            Shop shop = null;
            if(productDto.getShopId() != null){
                shop = shopMapper.dtoToEntity(shopService.getShopById(productDto.getShopId()));
                productDto.setCompanyId(shop.getCompanyId());
            }
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
