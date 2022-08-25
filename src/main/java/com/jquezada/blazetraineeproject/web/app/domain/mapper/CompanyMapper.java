package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.dto.CompanyDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Company;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.CompanyUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.CompanyResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company dtoToEntity(CompanyDto companyDto);
    CompanyDto entityToDto(Company company);
    CompanyResponse dtoToResponse(CompanyDto companyDto);
    List<Company> dtoListToEntities(List<CompanyDto> companyDtoList);
    List<CompanyDto> entitiesToDtoList(List<Company> companyList);
    List<CompanyResponse> dtoListToResponseList(List<CompanyDto> companyDtoList);
    CompanyDto addRequestToDto(CompanyAddRequest companyAddRequest);
    CompanyDto updateRequestToDto(CompanyUpdateRequest companyUpdateRequest);
}
