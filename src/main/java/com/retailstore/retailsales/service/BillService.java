package com.retailstore.retailsales.service;

import com.retailstore.retailsales.model.bill.BillInfo;
import com.retailstore.retailsales.model.cart.Cart;
import com.retailstore.retailsales.model.discount.DiscountMapper;
import com.retailstore.retailsales.model.products.Product;
import com.retailstore.retailsales.model.user.User;
import com.retailstore.retailsales.repository.CartRepository;
import com.retailstore.retailsales.repository.DiscountRepository;
import com.retailstore.retailsales.repository.ProductsRepository;
import com.retailstore.retailsales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private DiscountRepository discountRepository;

    public Optional<BillInfo> calculateBill(long userid) {
        final List<Cart> cartObjects = cartRepository.findAllByUserid(userid);
        cartObjects.stream().map(o -> getProductsPrice(o.getUserid(), o.getProductid()));
        return Optional.empty();
    }

    private List<Product> getProductsPrice(long userid, long productid) {
        Optional<User> user = userRepository.findById(userid);
        Optional<Product> product = productsRepository.findById(productid);
        List<DiscountMapper> discount = discountRepository.findAll();
        Optional<String> role;
        Optional<String> itemtype;
        if(user.isPresent() && product.isPresent()){
            role = Optional.of(user.get().getRole());
            itemtype = Optional.of(product.get().getItemtype());
            calculateDiscount(product.get().getItemprice(),role.get(),itemtype.get(),discount);

        }

        return
    }

    private float calculateDiscount(float itemprice , String role , String itemtype , List<DiscountMapper> discountMappers){
        float discount=0;
        for (int dmap =0; dmap<discountMappers.size();dmap++) {
            String key = discountMappers.get(dmap).getKEY();
            String rule = discountMappers.get(dmap).getRULE();
            String value = discountMappers.get(dmap).getVALUE();
            if (key.equals("PRODUCTTYPE") && rule.equals("GROCERY") && itemtype.equals("GROCERY")){
                return discount;
            }else
            switch (key) {
                case "EMPLOYEE":
                    if(role.equalsIgnoreCase(key))
                    return (itemprice*(Float.parseFloat(value)/100.0f));
                case "AFFILIATE": // Call to function
                    return (itemprice*(Float.parseFloat(value)/100.0f));
                case "CUSTOMER":
                    return (itemprice*(Float.parseFloat(value)/100.0f));
                case "TOTALBILL":


                default:
                    return 0;
            }
        }
    }
}
