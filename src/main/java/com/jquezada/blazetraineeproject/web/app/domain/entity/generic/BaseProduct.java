package com.jquezada.blazetraineeproject.web.app.domain.entity.generic;

import com.jquezada.blazetraineeproject.web.app.domain.generic.ShopBaseModel;

public class BaseProduct extends ShopBaseModel {

    public enum ProductSaleType {
        Medicinal,
        Recreational,
        Both
    }

    private String name;
    private String description;

    private ProductSaleType productSaleType = ProductSaleType.Both;

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

    public ProductSaleType getProductSaleType() {
        return productSaleType;
    }

    public void setProductSaleType(ProductSaleType productSaleType) {
        this.productSaleType = productSaleType;
    }
}
