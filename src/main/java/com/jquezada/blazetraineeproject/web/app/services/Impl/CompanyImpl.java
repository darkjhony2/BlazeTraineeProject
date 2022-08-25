package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.dto.CompanyDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Company;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.CompanyMapper;
import com.jquezada.blazetraineeproject.web.app.repositories.CompanyRepository;
import com.jquezada.blazetraineeproject.web.app.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyImpl implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyDto> getCompanies() {
        List<Company> list = new ArrayList<Company>();
        List<CompanyDto> listDto = new ArrayList<>();
        try{
            list = companyRepository.findAll();
            listDto = companyMapper.entitiesToDtoList(list);
        } catch (Exception e){
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public void saveCompany(CompanyDto companyDto) {
        try {
            companyRepository.save(companyMapper.dtoToEntity(companyDto));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompany(CompanyDto companyDto) {
        try {
            Company companyDB = companyRepository.findById(companyDto.getId()).orElse(null);
            if(companyDB != null){
                companyDB.setName(companyDto.getName());
                companyDB.setDescription(companyDto.getDescription());
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
