package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.jquezada.blazetraineeproject.web.app.domain.mapper.ProductMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ProductResponse;
import com.jquezada.blazetraineeproject.web.app.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/products")
public class ProductResource {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private IProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts(){
        return productMapper.dtoListToResponseList(productService.getProducts());
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductAddRequest productAddRequest){
        productService.saveProduct(productMapper.addRequestToDto(productAddRequest));
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest){
        productService.updateProduct(productMapper.updateRequestToDto(productUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProductById(id);
    }
}
