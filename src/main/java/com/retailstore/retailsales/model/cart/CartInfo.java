package com.retailstore.retailsales.model.cart;

import com.retailstore.retailsales.common.Builder;
import lombok.Data;

@Data
public class CartInfo {

    private long cartid;
    private long userid;
    private long productid;

    public static Builder<CartInfo> builder() {
        return Builder.of(CartInfo.class);
    }

    public static Builder<CartInfo> toBuilder(final Cart cart) {
        return builder().on(p -> p.getCartid()).set(cart.getCartid())
                .on(p -> p.getUserid()).set(cart.getUserid())
                .on(p -> p.getProductid()).set(cart.getProductid());
    }
}
