package com.service.advert.VO;

import org.bson.types.Binary;

public class Image {

    private String id;
    private Binary image;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }
}
