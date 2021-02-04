package com.service.advert.model;

import com.service.advert.VO.Image;
import org.springframework.data.annotation.Id;

public class AdvertImage {

    @Id
    private String id;

    private Advert advert;
    private Image image;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
