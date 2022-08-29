package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.annotations.CollectionName;
import com.jquezada.blazetraineeproject.web.app.domain.generic.CompanyBaseModel;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("roles")
public class Role extends CompanyBaseModel {
    private static final String ROLE_MANAGER = "Manager";
    private static final String ROLE_ADMIN = "Admin";
    private static final String ROLE_DISPATCHER = "Dispatcher";
    private static final String ROLE_SHOP_MANAGER = "Shop Manager";
    private static final String ROLE_SHOP_DISPATCHER = "Shop Dispatcher";
    private static final String ROLE_FRONT_DESK = "Front Desk";
    private static final String ROLE_DELIVERY_DRIVER = "Delivery Driver";
    private static final String ROLE_BUDTENDER = "Budtender";
    private static final String ROLE_INACTIVE = "Inactive";

    private ERole authority;

    public Role(ERole authority) {
        this.authority = authority;
    }

    public Role() {
    }

    public ERole getAuthority() {
        return authority;
    }

    public void setAuthority(ERole authority) {
        this.authority = authority;
    }
}
