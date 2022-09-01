package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Company;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CompanyResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company addRequestToEntity(CompanyAddRequest companyAddRequest);
    Company updateRequestToEntity(CompanyUpdateRequest companyUpdateRequest);
    CompanyResponse entityToResponse(Company company);
    List<Company> addRequestsToEntities(List<CompanyAddRequest> companyAddRequests);
    List<Company> updateRequestsToEntities(List<CompanyUpdateRequest> companyUpdateRequests);
    List<CompanyResponse> entitiesToResponses(List<Company> companies);
}
