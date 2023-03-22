package com.service.auth.vo;

import com.service.auth.domain.User;
import lombok.Data;

@Data
public class AccountWrapper {
    private Account account;
    private User user;
}
