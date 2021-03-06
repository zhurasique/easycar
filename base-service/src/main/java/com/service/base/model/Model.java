package com.service.base.model;

import org.springframework.data.annotation.Id;

public class Model {

    @Id
    private String id;
    private String name;

    private Brand brand;


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
