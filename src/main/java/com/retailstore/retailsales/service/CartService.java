package com.retailstore.retailsales.service;

import com.retailstore.retailsales.model.cart.Cart;
import com.retailstore.retailsales.model.cart.CartInfo;
import com.retailstore.retailsales.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Optional<CartInfo> save(CartInfo cartInfo){
        return Optional.of(CartInfo.toBuilder(cartRepository.save(Cart.toBuilder(cartInfo).build())).build());

    }
}
