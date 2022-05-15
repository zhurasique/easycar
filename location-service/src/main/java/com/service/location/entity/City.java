package com.service.location.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class City {
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private Region region;
}
