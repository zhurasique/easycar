package com.service.advert.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Image {
    @Id
    private String id;
    private boolean isMain;
    private Advert advert;
}
