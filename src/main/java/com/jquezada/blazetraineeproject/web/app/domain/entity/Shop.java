package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
import com.jquezada.blazetraineeproject.web.app.domain.generic.CompanyBaseModel;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("shops")
public class Shop extends CompanyBaseModel {
    private String name;
    private String description;
    private ShopType shopType;
    private String email;
    private String phoneNumber;
    private String license;
    private Address address;

    public enum ShopType {
        Medicinal,
        Recreational,
        Both;

        public static ShopType toShopType(String name) {
            if (name == null) {
                return Medicinal;
            }
            if (name.equalsIgnoreCase("Medicinal")) {
                return Medicinal;
            } else if (name.equalsIgnoreCase("Recreational")) {
                return Recreational;
            } else {
                return Both;
            }
        }
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

    public ShopType getShopType() {
        return shopType;
    }

    public void setShopType(ShopType shopType) {
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

    private static final long serialVersionUID = 3562377953373074506L;
}
