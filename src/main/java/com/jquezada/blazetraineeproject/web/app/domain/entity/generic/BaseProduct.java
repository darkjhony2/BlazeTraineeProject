package com.jquezada.blazetraineeproject.web.app.domain.entity.generic;

import com.jquezada.blazetraineeproject.web.app.domain.generic.ShopBaseModel;

public class BaseProduct extends ShopBaseModel {
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
