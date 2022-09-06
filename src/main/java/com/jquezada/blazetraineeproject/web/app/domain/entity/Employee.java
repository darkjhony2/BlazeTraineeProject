package com.jquezada.blazetraineeproject.web.app.domain.entity;

import com.jquezada.blazetraineeproject.web.app.domain.annotations.CollectionName;
import com.jquezada.blazetraineeproject.web.app.domain.generic.CompanyBaseModel;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Document("employees")
public class Employee extends CompanyBaseModel {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastname;

    @DBRef
    private Role role;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(max = 20)
    private String username;

    private String password;

    private List<String> shops = new ArrayList<>();
    private boolean disabled = false;

    public Employee(String firstName, String lastname, String email, String username, String password, String companyId, List<String> shops) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.companyId = companyId;
        this.shops = shops;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roleId) {
        this.role = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getShops() {
        return shops;
    }

    public void setShops(List<String> shops) {
        this.shops = shops;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
