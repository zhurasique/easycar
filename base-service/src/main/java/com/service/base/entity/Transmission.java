package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Transmission {
    @Id
    private String id;
    private String name;
}
