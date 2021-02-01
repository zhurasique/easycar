package com.service.advert.model;

import com.service.advert.VO.Brand;
import org.springframework.data.annotation.Id;

public class Advert {

    @Id
    private String id;
    private Brand brand;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
