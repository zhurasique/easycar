package com.service.account.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Account {
    @Id
    private String username;
    private String phoneNumber;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String photo;
}
