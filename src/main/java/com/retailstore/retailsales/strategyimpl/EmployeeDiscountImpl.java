package com.retailstore.retailsales.strategyimpl;

import com.retailstore.retailsales.repository.DiscountRepository;
import com.retailstore.retailsales.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDiscountImpl implements DiscountStrategy {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public float applyDiscount(float amount) {
        return (amount - (amount * Float.parseFloat(discountRepository.findByKeyEquals("EMPLOYEE").getValue())));
    }

}
