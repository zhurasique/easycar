package com.service.account.vo;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private AuthProvider provider;
}
