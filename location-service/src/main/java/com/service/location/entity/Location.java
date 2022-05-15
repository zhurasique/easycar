package com.service.location.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Location {
    @Id
    private String id;

    @NotNull
    private String streetName;

    @NotNull
    private City city;
}
