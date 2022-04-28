package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Power {
    @Id
    private String id;
    private int power;
}
