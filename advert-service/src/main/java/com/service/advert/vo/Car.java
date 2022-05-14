package com.service.advert.vo;

import lombok.Data;

@Data
public class Car {
    private String id;
    private Type type;
    private Generation generation;
    private Color color;
    private Fuel fuel;
    private Drive drive;
    private Transmission transmission;
    private int engineCapacity;
    private int power;
    private int yerOfProduction;
    private String vin;
    private long odometer;

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
