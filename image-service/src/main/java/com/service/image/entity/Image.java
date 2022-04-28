package com.service.image.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Image {
    @Id
    private String id;

    @NotNull
    private Binary image;
}
