package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.jquezada.blazetraineeproject.web.app.domain.mapper.ShopMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ShopResponse;
import com.jquezada.blazetraineeproject.web.app.services.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/shops")
public class ShopResource {

    @Autowired
    private IShopService shopService;

    @Autowired
    private ShopMapper shopMapper;

    @GetMapping
    public List<ShopResponse> getProducts(){
        return shopMapper.dtoListToResponseList(shopService.getShops());
    }

    @PostMapping
    public void saveShop(@RequestBody ShopAddRequest shopAddRequest){
        shopService.saveShop(shopMapper.addRequestToDto(shopAddRequest));
    }

    @PutMapping
    public void updateShop(@RequestBody ShopUpdateRequest shopUpdateRequest){
        shopService.updateShop(shopMapper.updateRequestToDto(shopUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteShop(@PathVariable String id){
        shopService.deleteShopId(id);
    }
}
