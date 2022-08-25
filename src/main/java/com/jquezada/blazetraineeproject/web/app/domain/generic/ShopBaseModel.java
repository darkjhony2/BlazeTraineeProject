package com.jquezada.blazetraineeproject.web.app.domain.generic;

public abstract class ShopBaseModel extends CompanyBaseModel {
    protected String shopId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
