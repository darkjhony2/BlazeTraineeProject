package com.jquezada.blazetraineeproject.web.app.services.Impl;

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
    public List<Product> getProducts() {
        List<Product> list = new ArrayList<Product>();
        try {
            list = productRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveProduct(Product product) {
        try {
            Shop shop = null;
            if(product.getShopId() != null){
                shop = shopService.getShopById(product.getShopId());
                product.setCompanyId(shop.getCompanyId());
            }
            productRepository.save(product);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            Product productDB = productRepository.findById(product.getId()).orElse(null);
            if(productDB != null){
                productDB.setName(product.getName());
                productDB.setDescription(product.getDescription());
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
