package com.retailstore.retailsales.repository;

import com.retailstore.retailsales.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {

}
