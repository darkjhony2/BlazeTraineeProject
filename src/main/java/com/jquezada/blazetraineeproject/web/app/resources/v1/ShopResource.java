package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jquezada.blazetraineeproject.web.app.config.CoreModule;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ShopMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ShopResponse;
import com.jquezada.blazetraineeproject.web.app.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/shops")
public class ShopResource {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<ShopResponse> getShops(){
        //ShopService shopService = injector.getInstance(ShopService.class);
        return shopMapper.dtoListToResponseList(shopService.getShops());
    }

    @PostMapping
    public void saveShop(@RequestBody ShopAddRequest shopAddRequest){
        //ShopService shopService = injector.getInstance(ShopService.class);
        shopService.saveShop(shopMapper.addRequestToDto(shopAddRequest));
    }

    @PutMapping
    public void updateShop(@RequestBody ShopUpdateRequest shopUpdateRequest){
        //ShopService shopService = injector.getInstance(ShopService.class);
        shopService.updateShop(shopMapper.updateRequestToDto(shopUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteShop(@PathVariable String id){
        //ShopService shopService = injector.getInstance(ShopService.class);
        shopService.deleteShopId(id);
    }
}
