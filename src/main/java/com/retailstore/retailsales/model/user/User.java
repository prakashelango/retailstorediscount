package com.retailstore.retailsales.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @Column
    private String username;

    @Column
    private String role;

    @Column
    private Date createddate;

    @Column
    private String password;
}
