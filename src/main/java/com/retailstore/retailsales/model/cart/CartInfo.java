package com.retailstore.retailsales.model.cart;

import com.retailstore.retailsales.common.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
public class CartInfo {

    private long id;
    private long userid;
    private long productid;

    public static Builder<CartInfo> builder() {
        return Builder.of(CartInfo.class);
    }

    public static Builder<CartInfo> toBuilder(final Cart cart) {
        return builder().on(p -> p.getId()).set(cart.getId())
                .on(p -> p.getProductid()).set(cart.getProductid())
                .on(p -> p.getUserid()).set(cart.getUserid());
    }
}
