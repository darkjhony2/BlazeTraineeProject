package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.dto.ShopDto;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ShopResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    Shop dtoToEntity(ShopDto shopDto);
    ShopDto entityToDto(Shop shop);
    ShopResponse dtoToResponse(ShopDto shopDto);
    List<Shop> dtoListToEntities(List<ShopDto> shopDtoList);
    List<ShopDto> entitiesToDtoList(List<Shop> shopList);
    List<ShopResponse> dtoListToResponseList(List<ShopDto> shopDtoList);
    ShopDto addRequestToDto(ShopAddRequest shopAddRequest);
    ShopDto updateRequestToDto(ShopUpdateRequest shopUpdateRequest);
}
