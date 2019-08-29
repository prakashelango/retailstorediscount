package com.retailstore.retailsales.model.bill;

import com.retailstore.retailsales.model.cart.Cart;
import lombok.Data;

@Data
public class BillInfo {
    private float totalamountafterdiscount;
    private float originalamount;
    private Cart cart;
}
