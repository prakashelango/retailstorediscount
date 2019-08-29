package com.retailstore.retailsales.model.bill;

import com.retailstore.retailsales.common.Builder;
import com.retailstore.retailsales.model.cart.Cart;
import lombok.Data;

@Data
public class BillInfo {
    private long id;
    private float totalamountafterdiscount;
    private float originalamount;
    private Cart cart;

    public static Builder<BillInfo> builder() {
        return Builder.of(BillInfo.class);
    }

    public static Builder<BillInfo> toBuilder(final Bill bill) {
        return builder().on(p -> p.getTotalamountafterdiscount()).set(bill.getTotalamountafterdiscount())
                .on(p -> p.getOriginalamount()).set(bill.getOriginalamount())
                .on(p -> p.getCart()).set(bill.getCart())
                .on(p -> p.getId()).set(bill.getId());
    }
}
