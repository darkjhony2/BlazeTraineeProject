package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.entity.generic.BaseCategory;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@CompoundIndexes(
        @CompoundIndex(name = "company_shop", def = "{companyId: 1, shopId:1, delete: 1}")
)
public class Category extends BaseCategory {

}
