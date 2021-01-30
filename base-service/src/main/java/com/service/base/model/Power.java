package com.service.base.model;

import org.springframework.data.annotation.Id;

public class Power {

    @Id
    private String id;
    private int power;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
