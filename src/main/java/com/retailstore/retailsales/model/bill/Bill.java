package com.retailstore.retailsales.model.bill;

import com.retailstore.retailsales.model.products.Product;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@
@Entity
@Data
public class Bill {

    List<Product> productList;
}
