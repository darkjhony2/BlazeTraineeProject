package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
import com.jquezada.blazetraineeproject.web.app.domain.generic.CompanyBaseModel;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("shops")
public class Shop extends CompanyBaseModel {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
