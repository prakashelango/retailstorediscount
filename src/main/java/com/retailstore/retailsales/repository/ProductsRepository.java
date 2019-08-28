package com.retailstore.retailsales.repository;

import com.retailstore.retailsales.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
