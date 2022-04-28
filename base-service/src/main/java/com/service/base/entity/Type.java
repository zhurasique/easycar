package com.service.base.entity;

import com.service.base.VO.ImageVO;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Type {
    @Id
    private String id;

    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private ImageVO imageVO;
}
