package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getCompanies();
    void saveCompany(CompanyDto companyDto);
    void updateCompany(CompanyDto companyDto);
    void deleteCompanyById(String companyId);
}
