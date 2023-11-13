package com.easycar.account.vo;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private AuthProvider provider;
    private String[] roles;
}
