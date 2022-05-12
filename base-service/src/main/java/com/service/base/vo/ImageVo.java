package com.service.base.vo;

import lombok.Data;
import org.bson.types.Binary;

@Data
public class ImageVo {
    private String id;
    private Binary image;
}
