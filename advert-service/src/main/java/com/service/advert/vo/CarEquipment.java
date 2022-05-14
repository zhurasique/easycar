package com.service.advert.vo;

import lombok.Data;

@Data
public class CarEquipment {
    private String id;
    private Car car;
    private Equipment equipment;
}
