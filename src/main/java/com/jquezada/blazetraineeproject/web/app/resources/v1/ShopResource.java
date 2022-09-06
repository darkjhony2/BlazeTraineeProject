package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.jquezada.blazetraineeproject.web.app.domain.mapper.ShopMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ShopUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ShopResponse;
import com.jquezada.blazetraineeproject.web.app.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    public List<ShopResponse> getShops(@RequestParam String username){
        //ShopService shopService = injector.getInstance(ShopService.class);
        return shopMapper.entitiesToResponses(shopService.getShops(username));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    public ShopResponse getShopById(@PathVariable String id){
        return shopMapper.entityToResponse(shopService.getShopById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void saveShop(@RequestBody ShopAddRequest shopAddRequest){
        //ShopService shopService = injector.getInstance(ShopService.class);
        shopService.saveShop(shopMapper.addRequestToEntity(shopAddRequest));
    }

    @PutMapping
    public void updateShop(@RequestBody ShopUpdateRequest shopUpdateRequest){
        //ShopService shopService = injector.getInstance(ShopService.class);
        shopService.updateShop(shopMapper.updateRequestToEntity(shopUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteShop(@PathVariable String id){
        //ShopService shopService = injector.getInstance(ShopService.class);
        shopService.deleteShopId(id);
    }
}
