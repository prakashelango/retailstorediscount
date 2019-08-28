package com.retailstore.retailsales.model.products;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String itemname;

    @Column
    private int itemqty;

    @Column
    private int itemprice;
}
