package com.easy.car.model;

import org.springframework.data.annotation.Id;

public class TypeModel {

    @Id
    private String id;

    private Model model;

    private Type type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
