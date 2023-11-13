package com.easycar.image.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Image {
    @Id
    private String id;

    @NotNull
    private byte[] base64Image;
}
