package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Drive {
    @Id
    private String id;
    private String name;
}
