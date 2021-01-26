package com.service.base.model;

import com.service.base.VO.Image;
import org.springframework.data.annotation.Id;

public class Brand {

    @Id
    private String id;
    private String name;
    private Image image;


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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
