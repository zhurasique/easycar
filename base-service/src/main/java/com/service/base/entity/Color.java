package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

@Data
public class Color {
    @Id
    private String id;

    @Size(min = 3, max = 15)
    private String color;

    @Size(min = 7, max = 7)
    private String pattern;
}
