package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Fuel {
    @Id
    private String id;
    private String name;
}
