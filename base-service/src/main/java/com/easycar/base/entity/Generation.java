package com.easycar.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Generation {
    @Id
    private String id;

    @Size(min = 1, max = 30)
    private String name;

    @DecimalMin("1900")
    @DecimalMax("2025")
    private int yearFrom;

    @DecimalMin("1900")
    @DecimalMax("2025")
    private int yearTo;

    @NotNull
    private Model model;
}
