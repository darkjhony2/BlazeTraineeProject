package com.jquezada.blazetraineeproject.web.app.domain.mapper;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Product;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Shop;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ProductResponse;
import com.jquezada.blazetraineeproject.web.app.resources.response.ShopResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    Shop addRequestToEntity(ShopAddRequest shopAddRequest);
    Shop updateRequestToEntity(ShopUpdateRequest shopUpdateRequest);
    ShopResponse entityToResponse(Shop shop);
    List<Shop> addRequestsToEntities(List<ShopAddRequest> addRequests);
    List<Shop> updateRequestsToEntities(List<ShopUpdateRequest> shopUpdateRequests);
    List<ShopResponse> entitiesToResponses(List<Shop> shops);
}
