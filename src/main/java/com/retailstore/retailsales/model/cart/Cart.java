package com.retailstore.retailsales.model.cart;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CART")
public class Cart {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long userid;

    @Column
    private long productid;
}
