package com.retailstore.retailsales.repository;

import com.retailstore.retailsales.model.discount.DiscountMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<DiscountMapper , Long> {

    DiscountMapper findByKeyEquals(String key);
}