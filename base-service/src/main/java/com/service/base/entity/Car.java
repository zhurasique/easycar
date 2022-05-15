package com.service.base.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class Car {
    @Id
    private String id;

    @NotNull
    private Type type;

    @NotNull
    private Generation generation;

    @NotNull
    private Color color;

    @NotNull
    private Fuel fuel;

    @NotNull
    private Drive drive;

    @NotNull
    private Transmission transmission;

    @DecimalMin("50")
    @DecimalMax("12000")
    private int engineCapacity;

    @DecimalMin("50")
    @DecimalMax("1500")
    private int power;

    @NotNull
    private int yerOfProduction;

    @DecimalMin("0")
    @DecimalMax("999999999")
    private long odometer;

    @Size(min = 17, max = 17)
    private String vin;         // cannot be changed in future

    private enum Fuel {
        DIESEL, GAS, LPG, GAS_LPG, ELECTRIC
    }

    private enum Drive {
        REAR, FRONT, FOUR_WHEEL, SIX_WHEEL
    }

    private enum Transmission {
        MANUAL, AUTOMATIC, ROBOTIC, VARIABLE
    }
}
