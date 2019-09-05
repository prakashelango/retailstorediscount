package com.retailstore.retailsales.factory;

import com.retailstore.retailsales.strategyimpl.AffiliateDiscountImpl;
import com.retailstore.retailsales.strategyimpl.Customer2YRSDiscountImpl;
import com.retailstore.retailsales.strategyimpl.EmployeeDiscountImpl;
import com.retailstore.retailsales.strategyimpl.GeneralDiscountImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscountFactory<T> {

    @Autowired
    private EmployeeDiscountImpl employeeDiscount;

    @Autowired
    private Customer2YRSDiscountImpl customer2YRSDiscount;

    @Autowired
    private AffiliateDiscountImpl affiliateDiscount;

    @Autowired
    private GeneralDiscountImpl generalDiscount;

    public T getDiscountObject(String type) {
        if (type.equalsIgnoreCase("EMPLOYEE")) {
            return (T) employeeDiscount;
        } else if (type.equalsIgnoreCase("CUSTOMER")) {
            return (T) customer2YRSDiscount;
        } else if (type.equalsIgnoreCase("AFFILIATE")) {
            return (T) affiliateDiscount;
        } else if (type.equalsIgnoreCase("GENERAL")) {
            return (T) generalDiscount;
        } else return null;
    }
}
