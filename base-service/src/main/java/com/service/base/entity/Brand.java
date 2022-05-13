package com.service.base.entity;

import com.service.base.vo.Image;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class Brand {
    @Id
    private String id;
    private String name;
    private Image image;

    @Data
    public static class Dto {
        @Size(min = 2, max = 30)
        private String name;

        @NotNull
        private MultipartFile image;
    }
}
