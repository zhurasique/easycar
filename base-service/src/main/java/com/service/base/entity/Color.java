package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Color {
    @Id
    private String id;
    private String color;
    private String pattern;
}
