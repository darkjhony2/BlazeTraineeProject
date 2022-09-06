package com.jquezada.blazetraineeproject.web.app.resources.request;

import com.jquezada.blazetraineeproject.web.app.domain.entity.generic.BaseProduct;

public class ProductAddRequest {
    private String name;
    private String description;
    private String shopId;

    private BaseProduct.ProductSaleType productSaleType;

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

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public BaseProduct.ProductSaleType getProductSaleType() {
        return productSaleType;
    }

    public void setProductSaleType(BaseProduct.ProductSaleType productSaleType) {
        this.productSaleType = productSaleType;
    }
}
