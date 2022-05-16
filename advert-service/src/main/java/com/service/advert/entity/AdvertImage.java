package com.service.advert.entity;

import com.service.advert.vo.Image;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class AdvertImage {
    @Id
    private String id;

    private boolean isMain;

    @NotNull
    private Advert advert;

    @NotNull
    private Image image;
}
