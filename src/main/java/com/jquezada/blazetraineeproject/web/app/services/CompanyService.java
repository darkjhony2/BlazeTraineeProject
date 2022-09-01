package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getCompanies();
    void saveCompany(Company company);
    void updateCompany(Company company);
    void deleteCompanyById(String companyId);
}
