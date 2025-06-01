package com.gabriel.springrestspecialist.core.validation.validator;

import com.gabriel.springrestspecialist.core.validation.ValidEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Stream;

public class ValidEnumValidator implements ConstraintValidator<ValidEnum, String> {
    private List<String> enumValues;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        enumValues = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
            .map(Enum::name)
            .toList();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return enumValues.contains(value);
    }
}
