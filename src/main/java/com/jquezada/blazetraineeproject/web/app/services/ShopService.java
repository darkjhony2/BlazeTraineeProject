package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> getShops(String employeeUsername);
    Shop getShopById(String shopId);
    void saveShop(Shop shop);
    void updateShop(Shop shop);
    void deleteShopId(String shopId);
}
