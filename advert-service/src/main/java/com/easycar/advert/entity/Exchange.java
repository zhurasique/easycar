package com.easycar.advert.entity;

import com.easycar.advert.entity.validation.SurchargeConstraint;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
public class Exchange {
    @Id
    private String id;

    @NotNull
    private Advert fromAdvert;

    @NotNull
    private Advert toAdvert;

    @NotNull
    @SurchargeConstraint
    private Surcharge surcharge;

    @Data
    public static class Surcharge {
        @DecimalMin("0")
        @DecimalMax("999999999")
        private int amount;

        @NotNull
        private SurchargeDirection direction;
    }

    public enum SurchargeDirection {
        FROM, TO, WITHOUT
    }
}
