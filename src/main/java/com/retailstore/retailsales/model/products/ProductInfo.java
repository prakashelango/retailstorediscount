package com.retailstore.retailsales.model.products;

import com.retailstore.retailsales.common.Builder;
import lombok.Data;

@Data
public class ProductInfo {
    private long id;
    private String itemname;
    private int itemqty;
    private float itemprice;
    private String itemtype;

    public static Builder<ProductInfo> builder() {
        return Builder.of(ProductInfo.class);
    }

    public static Builder<ProductInfo> toBuilder(final Product product) {
        return builder().on(p -> p.getId()).set(product.getId())
                .on(p -> p.getItemname()).set(product.getItemname())
                .on(p -> p.getItemprice()).set(product.getItemprice())
                .on(p -> p.getItemqty()).set(product.getItemqty())
                .on(p -> p.getItemtype()).set(product.getItemtype());
    }
}
