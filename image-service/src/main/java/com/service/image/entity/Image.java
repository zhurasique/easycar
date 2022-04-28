package com.service.image.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

@Data
public class Image {
    @Id
    private String id;
    private Binary image;
}
