package com.retailstore.retailsales.controller;

import com.retailstore.retailsales.model.cart.Cart;
import com.retailstore.retailsales.service.CartService;
import com.retailstore.retailsales.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping (value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public Optional<Cart> addProducts(@RequestBody Cart cart){
        return cartService.save(cart);
    }
}
