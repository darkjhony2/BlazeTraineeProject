package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Company;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.CompanyMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.CompanyRepository;
import com.jquezada.blazetraineeproject.web.app.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanies() {
        List<Company> list = new ArrayList<Company>();
        try{
            list = companyRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveCompany(Company company) {
        try {
            companyRepository.save(company);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompany(Company company) {
        try {
            Company companyDB = companyRepository.findById(company.getId()).orElse(null);
            if(companyDB != null){
                companyDB.setName(company.getName());
                companyDB.setDescription(company.getDescription());
                companyRepository.save(companyDB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompanyById(String companyId) {
        try {
            Company company = companyRepository.findById(companyId).orElse(null);
            if(company != null){
                company.setDeleted(true);
                companyRepository.save(company);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
