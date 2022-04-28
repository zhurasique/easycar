package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

@Data
public class Transmission {
    @Id
    private String id;

    @Size(min = 3, max = 15)
    private String name;
}
