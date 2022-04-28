package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class TypeModel {
    @Id
    private String id;

    private Model model;

    private Type type;
}
