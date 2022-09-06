package com.jquezada.blazetraineeproject.web.app.resources.request;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Address;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;

public class ShopUpdateRequest {

    private String id;
    private String name;
    private String description;
    private String companyId;
    private Shop.ShopType shopType;
    private Address address;

    private String email;
    private String phoneNumber;
    private String license;

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
}
