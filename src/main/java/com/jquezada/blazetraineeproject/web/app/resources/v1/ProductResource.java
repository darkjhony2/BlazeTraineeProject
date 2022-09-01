package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.google.inject.Inject;
import com.jquezada.blazetraineeproject.web.app.domain.mapper.ProductMapper;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductAddRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.ProductUpdateRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.ProductResponse;
import com.jquezada.blazetraineeproject.web.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/products")
public class ProductResource {
//    @Inject
//    Injector injector;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts(){
        //ProductService productService = injector.getInstance(ProductService.class);
        return productMapper.entitiesToResponses(productService.getProducts());
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductAddRequest productAddRequest){
        //ProductService productService = injector.getInstance(ProductService.class);
        productService.saveProduct(productMapper.addRequestToEntity(productAddRequest));
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest){
        //ProductService productService = injector.getInstance(ProductService.class);
        productService.updateProduct(productMapper.updateRequestToEntity(productUpdateRequest));
    }

    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id){
        //ProductService productService = injector.getInstance(ProductService.class);
        productService.deleteProductById(id);
    }
}
