package com.service.advert.entity.validation;

import com.service.advert.entity.Exchange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SurchargeValidator implements ConstraintValidator<SurchargeConstraint, Exchange.Surcharge> {
    @Override
    public boolean isValid(Exchange.Surcharge surcharge, ConstraintValidatorContext constraintValidatorContext) {
        if (Exchange.SurchargeDirection.WITHOUT.equals(surcharge.getDirection())) {
            return surcharge.getAmount() == 0;
        } else {
            return surcharge.getAmount() >= 1;
        }
    }
}
