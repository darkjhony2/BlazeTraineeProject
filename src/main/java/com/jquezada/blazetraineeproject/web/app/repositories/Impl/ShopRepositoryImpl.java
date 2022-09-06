//package com.jquezada.blazetraineeproject.web.app.repositories.Impl;
//
//import com.jquezada.blazetraineeproject.web.app.domain.db.MongoDb;
//import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
//import com.jquezada.blazetraineeproject.web.app.repositories.ShopRepository;
//import com.jquezada.blazetraineeproject.web.app.repositories.generic.impl.MongoCompanyBaseRepositoryImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ShopRepositoryImpl extends MongoCompanyBaseRepositoryImpl<Shop> implements ShopRepository {
//
//    public ShopRepositoryImpl(MongoDb mongoManager) throws Exception {
//        super(Shop.class, mongoManager);
//    }
//
//    @Override
//    public List<Shop> getShopsByCompanyId(String companyId) {
//        return null;
//    }
//
//    @Override
//    public List<Shop> getShopsByIdIn(List<String> ids) {
//        return null;
//    }
//}
