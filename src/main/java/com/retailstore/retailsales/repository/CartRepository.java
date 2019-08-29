package com.retailstore.retailsales.repository;

import com.retailstore.retailsales.model.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserid(long userid);
}
