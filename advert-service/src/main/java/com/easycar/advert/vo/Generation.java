package com.easycar.advert.vo;

import lombok.Data;

@Data
public class Generation {
    private String id;
    private String name;
    private int yearFrom;
    private int yearTo;
    private Model model;
}
