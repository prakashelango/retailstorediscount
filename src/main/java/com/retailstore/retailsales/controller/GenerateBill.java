package com.retailstore.retailsales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/bill")
public class GenerateBill {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/applydiscount" , method = RequestMethod.POST)
    public Optional<> addProducts(@RequestBody CartInfo cartInfo){
        return cartService.save(cartInfo);
    }
}
