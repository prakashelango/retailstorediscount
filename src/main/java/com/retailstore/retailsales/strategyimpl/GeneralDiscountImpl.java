package com.retailstore.retailsales.strategyimpl;

import com.retailstore.retailsales.repository.DiscountRepository;
import com.retailstore.retailsales.strategy.GeneralDiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralDiscountImpl implements GeneralDiscountStrategy {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public float applyDiscount(float amount) {
        return Math.round(amount - (amount / Float.parseFloat(discountRepository.findByKeyEquals("TOTALBILL").getRule())) * Float.parseFloat(discountRepository.findByKeyEquals("TOTALBILL").getValue()));
    }

}
