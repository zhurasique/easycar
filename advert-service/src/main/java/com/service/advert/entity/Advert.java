package com.service.advert.entity;

import com.service.advert.vo.Car;
import com.service.advert.vo.Location;
import com.service.advert.vo.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Advert {
    @Id
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @DecimalMin("30")
    @DecimalMax("999999999")
    private int price;

    @NotNull
    private boolean isActive;

    private LocalDateTime postDateTime;

    @NotNull
    private Currency currency;

    @NotNull
    private Car car;

    @NotNull
    private User user;

    @NotNull
    private Location location;

    private enum Currency {
        USD, EUR, UAH
    }
}
