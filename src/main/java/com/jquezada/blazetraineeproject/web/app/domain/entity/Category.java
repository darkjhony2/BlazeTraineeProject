package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.entity.generic.BaseCategory;
import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@CompoundIndexes({
    @CompoundIndex(name = "company_shop", def = "{'shopId': 1, 'companyId': 1}")
})
public class Category extends BaseCategory {

}
