package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Model {

    @Id
    private String id;
    private String name;

    private Brand brand;
}
