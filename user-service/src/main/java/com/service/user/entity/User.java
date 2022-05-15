package com.service.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
    @Id
    private String id;

    @Size(min = 10, max = 17)
    private String phoneNumber;

    @NotNull
    private String name;
}
