package com.retailstore.retailsales.controller;

import com.retailstore.retailsales.model.bill.BillInfo;
import com.retailstore.retailsales.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/bill")
public class GenerateBill {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/applydiscount/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BillInfo> add(@PathVariable("id") long userid){
        return billService.calculateBill(userid);
    }
}
