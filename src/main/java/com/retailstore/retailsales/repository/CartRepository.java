package com.retailstore.retailsales.repository;

import com.retailstore.retailsales.model.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
