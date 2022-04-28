package com.service.base.VO;

import lombok.Data;
import org.bson.types.Binary;

@Data
public class ImageVO {
    private String id;
    private Binary image;
}
