package com.retailstore.retailsales.model.cart;

import com.retailstore.retailsales.common.Builder;
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

    public static Builder<Cart> builder() {
        return Builder.of(Cart.class);
    }

    public static Builder<Cart> toBuilder(final CartInfo cartInfo) {
        return builder().on(p -> p.getId()).set(cartInfo.getId())
                .on(p -> p.getProductid()).set(cartInfo.getProductid())
                .on(p -> p.getUserid()).set(cartInfo.getUserid());
    }
}
