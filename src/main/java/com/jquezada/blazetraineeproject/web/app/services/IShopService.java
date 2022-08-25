package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.dto.ShopDto;

import java.util.List;

public interface IShopService {

    List<ShopDto> getShops();
    void saveShop(ShopDto shopDto);
    void updateShop(ShopDto shopDto);
    void deleteShopId(String shopId);
}
