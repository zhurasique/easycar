package com.service.advert.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Advert {
    @Id
    private String id;
    private String title;
    private long odometer;
    private int price;
    private Currency currency;



    private enum Currency {
        EUR, USD, UAH
    }
}
