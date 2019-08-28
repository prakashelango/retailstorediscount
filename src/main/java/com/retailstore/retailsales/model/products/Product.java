package com.retailstore.retailsales.model.products;

import com.retailstore.retailsales.common.Builder;
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

    @Column
    private String itemtype;

    public static Builder<Product> builder() {
        return Builder.of(Product.class);
    }

    public static Builder<Product> toBuilder(final ProductInfo productInfo) {
        return builder().on(p -> p.getId()).set(productInfo.getId())
                .on(p -> p.getItemname()).set(productInfo.getItemname())
                .on(p -> p.getItemprice()).set(productInfo.getItemprice())
                .on(p -> p.getItemqty()).set(productInfo.getItemqty())
                .on(p -> p.getItemtype()).set(productInfo.getItemtype());
    }
}
