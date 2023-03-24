package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Region {
    @Id
    private String id;

    @NotNull
    private String name;
}
