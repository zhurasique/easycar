package com.easycar.advert.vo;

import lombok.Data;

@Data
public class Location {
    private String id;
    private String streetName;
    private City city;
}
