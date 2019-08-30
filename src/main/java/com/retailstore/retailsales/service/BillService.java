package com.retailstore.retailsales.service;

import com.retailstore.retailsales.common.Builder;
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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<BillInfo> billInfos = cartObjects.stream().map(o -> getProductsPrice(o.getUserid(), o.getProductid())).collect(Collectors.toList());
        BillInfo billinfo = getBillInfo(0,0);
        for (int bill=0; bill<billInfos.size(); bill++){
            billinfo.setOriginalamount(billinfo.getOriginalamount()+billInfos.get(bill).getOriginalamount());
            billinfo.setTotalamountafterdiscount(billinfo.getTotalamountafterdiscount()+billInfos.get(bill).getTotalamountafterdiscount());
        }
        return Optional.of(billinfo);
    }

    private BillInfo getProductsPrice(long userid, long productid) {
        Optional<User> user = userRepository.findById(userid);
        Optional<Product> product = productsRepository.findById(productid);
        List<DiscountMapper> discount = discountRepository.findAll();
        Optional<String> role;
        Optional<String> itemtype;
        if(user.isPresent() && product.isPresent()){
            role = Optional.of(user.get().getRole());
            itemtype = Optional.of(product.get().getItemtype());
           return getBillInfo(calculateDiscount(user.get().getCreateddate() , product.get().getItemprice(),role.get(),itemtype.get(),discount) , product.get().getItemprice());
        }
        return getBillInfo(0,0);
    }

    private BillInfo getBillInfo(float afterDiscount , float itemoriginalPrice){
        return BillInfo.builder().on(billInfo -> billInfo.getOriginalamount()).set(itemoriginalPrice)
                .on(billInfo -> billInfo.getTotalamountafterdiscount()).set(afterDiscount)
                .on(billInfo -> billInfo.getId()).set(0l).build();
    }
    private float calculateDiscount(Date usercreationDate, float itemprice , String role , String itemtype , List<DiscountMapper> discountMappers){
        float discount=0;
        for (int dmap =0; dmap<discountMappers.size();dmap++) {
            String key = discountMappers.get(dmap).getKEY();
            String rule = discountMappers.get(dmap).getRULE();
            String value = discountMappers.get(dmap).getVALUE();
            System.out.println("Key"+key +"rule" + rule + "value"+value);
            if (!rule.equals("GROCERY") && !itemtype.equals("GROCERY")) {
                switch (key) {
                    case "EMPLOYEE":
                        if (role.equalsIgnoreCase(key))
                            return itemprice - (itemprice * (Float.parseFloat(value) / 100.0f));
                    case "AFFILIATE":
                        return itemprice - (itemprice * (Float.parseFloat(value) / 100.0f));
                    case "CUSTOMER":
                        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                        if (usercreationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().isBefore(localDateTime.minusYears(Long.parseLong(rule))))
                            return itemprice - (itemprice * (Float.parseFloat(value) / 100.0f));
                    case "TOTALBILL":
                        if (itemprice > Float.parseFloat(rule))
                            return itemprice - (itemprice / Integer.parseInt(rule)) * Integer.parseInt(value);
                    default:
                        return itemprice - discount;
                }
            }
        }
        return discount;
    }

}
