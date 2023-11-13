package com.easycar.account.vo;

import com.easycar.account.entity.Account;
import lombok.Data;

@Data
public class AccountWrapper {
    private Account account;
    private User user;
}
