package com.jquezada.blazetraineeproject.web.app.resources.response;

import com.jquezada.blazetraineeproject.web.app.domain.entity.generic.BaseProduct;

public class ProductResponse {

    private String id;
    private String name;
    private String description;

    private BaseProduct.ProductSaleType productSaleType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public BaseProduct.ProductSaleType getProductSaleType() {
        return productSaleType;
    }

    public void setProductSaleType(BaseProduct.ProductSaleType productSaleType) {
        this.productSaleType = productSaleType;
    }
}
