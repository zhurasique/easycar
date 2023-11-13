package com.easycar.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Color {
    @Id
    private String id;

    @NotNull
    @Size(min = 3, max = 15)
    private String color;

    @NotNull
    @Size(min = 7, max = 7)
    private String pattern;
}
