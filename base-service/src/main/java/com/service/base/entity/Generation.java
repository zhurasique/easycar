package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Generation {
    @Id
    private String id;
    private String name;
    private int yearFrom;
    private int yearTo;

    private Model model;
}
