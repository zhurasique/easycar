package com.service.account.vo;

import com.service.account.entity.Account;
import lombok.Data;

@Data
public class AccountWrapper {
    private Account account;
    private User user;
}
