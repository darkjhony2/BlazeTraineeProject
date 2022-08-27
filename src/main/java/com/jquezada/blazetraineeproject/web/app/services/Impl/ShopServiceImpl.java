package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.google.inject.Inject;
import com.jquezada.blazetraineeproject.web.app.domain.dto.ShopDto;
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
    public List<ShopDto> getShops() {
        List<Shop> list = new ArrayList<Shop>();
        List<ShopDto> listDto = new ArrayList<>();
        try {
            list = shopRepository.findAll();
            listDto = shopMapper.entitiesToDtoList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public ShopDto getShopById(String shopId) {
        ShopDto shopDto = null;
        try {
            Shop shop = shopRepository.findById(shopId).orElse(null);
            if(shop != null){
                shopDto = shopMapper.entityToDto(shop);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return shopDto;
    }

    @Override
    public void saveShop(ShopDto shopDto) {
        try {
            shopRepository.save(shopMapper.dtoToEntity(shopDto));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateShop(ShopDto shopDto) {
        try {
            Shop shopDB = shopRepository.findById(shopDto.getId()).orElse(null);
            if(shopDB != null){
                shopDB.setName(shopDto.getName());
                shopDB.setDescription(shopDto.getDescription());
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
