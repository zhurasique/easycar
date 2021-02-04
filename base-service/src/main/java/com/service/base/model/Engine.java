package com.service.base.model;

import org.springframework.data.annotation.Id;

public class Engine {

    @Id
    private String id;
    private int capacity;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
