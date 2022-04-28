package com.service.base.entity;

import com.service.base.VO.ImageVO;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Type {
    @Id
    private String id;
    private String name;

    private ImageVO imageVO;
}
