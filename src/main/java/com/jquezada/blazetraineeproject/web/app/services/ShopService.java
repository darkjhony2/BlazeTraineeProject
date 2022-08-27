package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.dto.ShopDto;

import java.util.List;

public interface ShopService {

    List<ShopDto> getShops();
    ShopDto getShopById(String shopId);
    void saveShop(ShopDto shopDto);
    void updateShop(ShopDto shopDto);
    void deleteShopId(String shopId);
}
