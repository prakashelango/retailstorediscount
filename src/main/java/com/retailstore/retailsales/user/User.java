package com.retailstore.retailsales.user;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private long userid;
    private String username;
    private String role;
    private Date createddate;
    private String password;
}
