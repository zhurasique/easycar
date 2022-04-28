package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Model {

    @Id
    private String id;

    @Size(min = 1, max = 30)
    private String name;

    @NotNull
    private Brand brand;
}
