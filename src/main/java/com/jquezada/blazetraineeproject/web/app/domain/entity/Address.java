package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jquezada.blazetraineeproject.web.app.domain.generic.CompanyBaseModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends CompanyBaseModel {

    public static final String DEFAULT_COUNTRY = "US";
    private String address = "";
    private String city = "";
    private String state = "";
    private String zipCode = "";
    private String country = DEFAULT_COUNTRY;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private static final long serialVersionUID = 1918400798765554514L;
}
