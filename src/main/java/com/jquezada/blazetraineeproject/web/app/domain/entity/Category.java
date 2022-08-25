package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.entity.generic.BaseCategory;
import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
public class Category extends BaseCategory {

}
