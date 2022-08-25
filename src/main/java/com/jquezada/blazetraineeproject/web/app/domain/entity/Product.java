package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.entity.generic.BaseProduct;
import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product extends BaseProduct {
}
