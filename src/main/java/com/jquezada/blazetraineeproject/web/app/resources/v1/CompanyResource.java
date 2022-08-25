package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.jquezada.blazetraineeproject.web.app.domain.mapper.CompanyMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CompanyResponse;
import com.jquezada.blazetraineeproject.web.app.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/companies")
public class CompanyResource {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private ICompanyService companyService;

    @GetMapping
    public List<CompanyResponse> getCompanies(){
        return companyMapper.dtoListToResponseList(companyService.getCompanies());
    }

    @PostMapping
    public void saveCompany(@RequestBody CompanyAddRequest companyAddRequest){
        companyService.saveCompany(companyMapper.addRequestToDto(companyAddRequest));
    }

    @PutMapping
    public void updateCompany(@RequestBody CompanyUpdateRequest companyUpdateRequest){
        companyService.updateCompany(companyMapper.updateRequestToDto(companyUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteCompany(@PathVariable String id){
        companyService.deleteCompanyById(id);
    }
}
