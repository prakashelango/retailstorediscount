package com.retailstore.retailsales.model.user;

import com.retailstore.retailsales.common.Builder;
import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {

    private long userid;
    private String username;
    private String role;
    private Date createddate;
    private String password;

    public static Builder<UserInfo> builder() {
        return Builder.of(UserInfo.class);
    }

    public static Builder<UserInfo> toBuilder(final User user) {
        return builder().on(u -> u.getUserid()).set(user.getUserid())
                .on(u -> u.getUsername()).set(user.getUsername())
                .on(u -> u.getRole()).set(user.getRole())
                .on(u -> u.getCreateddate()).set(user.getCreateddate())
                .on(u -> u.getPassword()).set(user.getPassword());
    }
}
