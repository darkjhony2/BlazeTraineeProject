package com.jquezada.blazetraineeproject.web.app.repositories;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
import com.jquezada.blazetraineeproject.web.app.repositories.generic.MongoCompanyBaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShopRepository extends MongoCompanyBaseRepository<Shop> {
    List<Shop> getShopsByCompanyId(String companyId);

}
