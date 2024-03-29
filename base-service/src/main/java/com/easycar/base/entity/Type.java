package com.easycar.base.entity;

import com.easycar.base.vo.Image;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class Type {
    @Id
    private String id;

    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private Image image;

    @Data
    public static class Dto {
        @Size(min = 2, max = 30)
        private String name;

        @NotNull
        private MultipartFile image;
    }
}
