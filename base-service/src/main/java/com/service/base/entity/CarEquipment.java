package com.service.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class CarEquipment {
    @Id
    private String id;

    @NotNull
    private Car car;

    @NotNull
    private Equipment equipment;
}
