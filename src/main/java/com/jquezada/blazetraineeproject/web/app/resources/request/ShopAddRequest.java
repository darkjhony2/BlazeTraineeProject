package com.jquezada.blazetraineeproject.web.app.resources.request;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Address;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;

public class ShopAddRequest {

    private String name;
    private String description;
    private String companyId;
    private String email;
    private String phoneNumber;
    private String license;
    private Address address;
    private Boolean showWalkInQueue = true;
    private Boolean showDeliveryQueue = true;
    private Boolean showOnlineQueue = false;
    private Boolean showSpecialQueue = false;
    private Boolean enableCashInOut = false;
    private Boolean active = true;
    private Boolean enableSaleLogout = false;

    private Shop.ShopType shopType;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Shop.ShopType getShopType() {
        return shopType;
    }

    public void setShopType(Shop.ShopType shopType) {
        this.shopType = shopType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getShowWalkInQueue() {
        return showWalkInQueue;
    }

    public void setShowWalkInQueue(Boolean showWalkInQueue) {
        this.showWalkInQueue = showWalkInQueue;
    }

    public Boolean getShowDeliveryQueue() {
        return showDeliveryQueue;
    }

    public void setShowDeliveryQueue(Boolean showDeliveryQueue) {
        this.showDeliveryQueue = showDeliveryQueue;
    }

    public Boolean getShowOnlineQueue() {
        return showOnlineQueue;
    }

    public void setShowOnlineQueue(Boolean showOnlineQueue) {
        this.showOnlineQueue = showOnlineQueue;
    }

    public Boolean getShowSpecialQueue() {
        return showSpecialQueue;
    }

    public void setShowSpecialQueue(Boolean showSpecialQueue) {
        this.showSpecialQueue = showSpecialQueue;
    }

    public Boolean getEnableCashInOut() {
        return enableCashInOut;
    }

    public void setEnableCashInOut(Boolean enableCashInOut) {
        this.enableCashInOut = enableCashInOut;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getEnableSaleLogout() {
        return enableSaleLogout;
    }

    public void setEnableSaleLogout(Boolean enableSaleLogout) {
        this.enableSaleLogout = enableSaleLogout;
    }
}
