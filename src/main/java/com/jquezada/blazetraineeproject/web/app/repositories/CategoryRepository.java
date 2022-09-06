package com.jquezada.blazetraineeproject.web.app.repositories;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Category;
import com.jquezada.blazetraineeproject.web.app.repositories.generic.MongoShopBaseRespository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends MongoShopBaseRespository<Category> {
}
