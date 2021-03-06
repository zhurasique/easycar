package com.service.base.model;

import org.springframework.data.annotation.Id;

public class Color {

    @Id
    private String id;
    private String color;
    private String pattern;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
