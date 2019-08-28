package com.retailstore.retailsales.controller;


import com.retailstore.retailsales.model.products.ProductInfo;
import com.retailstore.retailsales.service.ProductsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    private ProductsService productsService;

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public Optional<ProductInfo> addProducts(@RequestBody ProductInfo productInfo){
        return productsService.save(productInfo);
    }
}
