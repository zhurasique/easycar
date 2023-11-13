package com.easycar.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Equipment {
    @Id
    private String id;

    @NotNull
    private String name;
}
