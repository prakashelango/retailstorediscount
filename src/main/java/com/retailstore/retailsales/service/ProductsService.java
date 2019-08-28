package com.retailstore.retailsales.service;

import com.retailstore.retailsales.model.products.Product;
import com.retailstore.retailsales.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public Optional<Product> save(Product product){
        return Optional.of(productsRepository.save(product));
    }
}
