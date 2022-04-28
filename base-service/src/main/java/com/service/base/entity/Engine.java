package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Engine {
    @Id
    private String id;
    private int capacity;
}
