package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ShopMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.ShopRepository;
import com.jquezada.blazetraineeproject.web.app.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> getShops() {
        List<Shop> list = new ArrayList<Shop>();
        try {
            list = shopRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Shop getShopById(String shopId) {
        Shop shop = null;
        try {
            shop = shopRepository.findById(shopId).orElse(null);
        } catch (Exception e){
            e.printStackTrace();
        }
        return shop;
    }

    @Override
    public void saveShop(Shop shop) {
        try {
            shopRepository.save(shop);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateShop(Shop shop) {
        try {
            Shop shopDB = shopRepository.findById(shop.getId()).orElse(null);
            if(shopDB != null){
                shopDB.setName(shop.getName());
                shopDB.setDescription(shop.getDescription());
                shopRepository.save(shopDB);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteShopId(String shopId) {
        try {
            Shop shop = shopRepository.findById(shopId).orElse(null);
            if(shop != null){
                shop.setDeleted(true);
                shopRepository.save(shop);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
