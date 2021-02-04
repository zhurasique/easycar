package com.service.advert.model;

import com.service.advert.VO.*;
import org.springframework.data.annotation.Id;

public class Advert {

    @Id
    private String id;

    // private User user;

    private Brand brand;
    private Color color;
    private Drive drive;
    private Fuel fuel;
    private Generation generation;
    private Model model;
    private Transmission transmission;
    private Type type;

    private int withMechanicalDamage;
    private int withVisualDamage;
    private int afterCollision;
    private int isRegistered;


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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getWithMechanicalDamage() {
        return withMechanicalDamage;
    }

    public void setWithMechanicalDamage(int withMechanicalDamage) {
        this.withMechanicalDamage = withMechanicalDamage;
    }

    public int getWithVisualDamage() {
        return withVisualDamage;
    }

    public void setWithVisualDamage(int withVisualDamage) {
        this.withVisualDamage = withVisualDamage;
    }

    public int getAfterCollision() {
        return afterCollision;
    }

    public void setAfterCollision(int afterCollision) {
        this.afterCollision = afterCollision;
    }

    public int getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(int isRegistered) {
        this.isRegistered = isRegistered;
    }
}
