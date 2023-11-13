package com.easycar.auth.vo;

import com.easycar.auth.domain.User;
import lombok.Data;

@Data
public class AccountWrapper {
    private Account account;
    private User user;
}
