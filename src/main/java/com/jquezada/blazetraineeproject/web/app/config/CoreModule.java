package com.jquezada.blazetraineeproject.web.app.config;

import com.google.inject.AbstractModule;
import com.jquezada.blazetraineeproject.web.app.repositories.CategoryRepository;
import com.jquezada.blazetraineeproject.web.app.services.CategoryService;
import com.jquezada.blazetraineeproject.web.app.services.CompanyService;
import com.jquezada.blazetraineeproject.web.app.services.Impl.CategoryServiceImpl;
import com.jquezada.blazetraineeproject.web.app.services.Impl.CompanyServiceImpl;
import com.jquezada.blazetraineeproject.web.app.services.Impl.ProductServiceImpl;
import com.jquezada.blazetraineeproject.web.app.services.Impl.ShopServiceImpl;
import com.jquezada.blazetraineeproject.web.app.services.ProductService;
import com.jquezada.blazetraineeproject.web.app.services.ShopService;
import org.springframework.data.mongodb.repository.MongoRepository;

public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CategoryService.class).to(CategoryServiceImpl.class);
        bind(ProductService.class).to(ProductServiceImpl.class);
        bind(ShopService.class).to(ShopServiceImpl.class);
        bind(CompanyService.class).to(CompanyServiceImpl.class);
    }


}
