package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.CompanyMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CompanyResponse;
import com.jquezada.blazetraineeproject.web.app.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/companies")
public class CompanyResource {

//    @Inject
//    Injector injector;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyMapper companyMapper;

    @GetMapping
    public List<CompanyResponse> getCompanies(){
        //CompanyService companyService = injector.getInstance(CompanyService.class);
        return companyMapper.dtoListToResponseList(companyService.getCompanies());
    }

    @PostMapping
    public void saveCompany(@RequestBody CompanyAddRequest companyAddRequest){
        //CompanyService companyService = injector.getInstance(CompanyService.class);
        companyService.saveCompany(companyMapper.addRequestToDto(companyAddRequest));
    }

    @PutMapping
    public void updateCompany(@RequestBody CompanyUpdateRequest companyUpdateRequest){
        //CompanyService companyService = injector.getInstance(CompanyService.class);
        companyService.updateCompany(companyMapper.updateRequestToDto(companyUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteCompany(@PathVariable String id){
        //CompanyService companyService = injector.getInstance(CompanyService.class);
        companyService.deleteCompanyById(id);
    }
}
