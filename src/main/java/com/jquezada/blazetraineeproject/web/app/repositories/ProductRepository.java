package com.jquezada.blazetraineeproject.web.app.repositories;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Product;
import com.jquezada.blazetraineeproject.web.app.repositories.generic.BaseRepository;
import com.jquezada.blazetraineeproject.web.app.repositories.generic.MongoShopBaseRespository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends MongoShopBaseRespository<Product> {
    
}
