package com.retailstore.retailsales.model.user;

import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {

    private long userid;
    private String username;
    private String role;
    private Date createddate;
    private String password;
}
