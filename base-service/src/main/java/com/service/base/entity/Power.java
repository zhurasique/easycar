package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Data
public class Power {
    @Id
    private String id;

    @DecimalMin("50")
    @DecimalMax("1500")
    private int power;
}
