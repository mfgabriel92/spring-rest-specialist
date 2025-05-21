package com.gabriel.springrestspecialist.core.validation.validator;

import com.gabriel.springrestspecialist.core.validation.Multiple;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class MultipleValidator implements ConstraintValidator<Multiple, Number> {
    private int number;

    @Override
    public void initialize(Multiple constraintAnnotation) {
        this.number = constraintAnnotation.number();
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        var decimalNumber = BigDecimal.valueOf(value.doubleValue());
        var decimalMultiple = BigDecimal.valueOf(this.number);
        var result = decimalNumber.remainder(decimalMultiple);

        return BigDecimal.ZERO.compareTo(result) == 0;
    }
}
