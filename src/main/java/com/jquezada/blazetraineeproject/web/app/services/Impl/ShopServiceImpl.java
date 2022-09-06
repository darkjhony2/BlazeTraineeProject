package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.entity.ERole;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Employee;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ShopMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.ShopRepository;
import com.jquezada.blazetraineeproject.web.app.services.EmployeeService;
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
    private EmployeeService employeeService;

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> getShops(String employeeUsername) {
        List<Shop> list = null;
        try {
            Employee employee = employeeService.findByUsername(employeeUsername);
            if(employee.getRole().getAuthority() == ERole.ROLE_ADMIN && employee.getCompanyId() != null){
                list = shopRepository.getShopsByCompanyId(employee.getCompanyId());
            }else{
                list =shopRepository.getShopsByIdIn(employee.getShops());
            }
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
                if(shop.getName() != null) shopDB.setName(shop.getName());
                if(shop.getDescription() != null) shopDB.setDescription(shop.getDescription());
                if(shop.getShopType() != null) shopDB.setShopType(shop.getShopType());
                if(shop.getEmail() != null) shopDB.setEmail(shop.getEmail());
                if(shop.getPhoneNumber() != null) shopDB.setPhoneNumber(shop.getPhoneNumber());
                if(shop.getLicense() != null) shopDB.setLicense(shop.getLicense());
                if(shop.getAddress() != null) shopDB.setAddress(shop.getAddress());
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
