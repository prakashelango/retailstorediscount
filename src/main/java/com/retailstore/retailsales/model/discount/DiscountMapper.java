package com.retailstore.retailsales.model.discount;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "DISCOUNTMAPPER")
@Entity
public class DiscountMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String KEY,RULE,VALUE;
}
