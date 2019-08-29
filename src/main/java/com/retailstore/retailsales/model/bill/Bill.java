package com.retailstore.retailsales.model.bill;

import com.retailstore.retailsales.model.cart.Cart;
import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Bill {

    @Id
    private long id;

    @JoinColumn(name = "CARTID")
    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    @Column
    private float totalamountafterdiscount;

    @Column
    private float originalamount;
}