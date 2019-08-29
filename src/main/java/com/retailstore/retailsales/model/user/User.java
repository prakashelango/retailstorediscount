package com.retailstore.retailsales.model.user;

import com.retailstore.retailsales.common.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USERID")
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

    public static Builder<User> builder() {
        return Builder.of(User.class);
    }

    public static Builder<User> toBuilder(final UserInfo userInfo) {
        return builder().on(u -> u.getUserid()).set(userInfo.getUserid())
                .on(u -> u.getUsername()).set(userInfo.getUsername())
                .on(u -> u.getRole()).set(userInfo.getRole())
                .on(u -> u.getCreateddate()).set(userInfo.getCreateddate())
                .on(u -> u.getPassword()).set(userInfo.getPassword());
    }
}
