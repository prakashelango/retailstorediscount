package com.retailstore.retailsales.service;

import com.retailstore.retailsales.model.cart.Cart;
import com.retailstore.retailsales.model.user.User;
import com.retailstore.retailsales.model.user.UserInfo;
import com.retailstore.retailsales.repository.CartRepository;
import com.retailstore.retailsales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserInfo> save(UserInfo userInfo){
        return Optional.of(UserInfo.toBuilder(userRepository.save(User.toBuilder(userInfo).build())).build());
    }
}
