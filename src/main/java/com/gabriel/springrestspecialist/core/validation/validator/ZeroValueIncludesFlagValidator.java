package com.gabriel.springrestspecialist.core.validation.validator;

import com.gabriel.springrestspecialist.core.validation.ZeroValueIncludesFlag;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.math.BigDecimal;

public class ZeroValueIncludesFlagValidator implements ConstraintValidator<ZeroValueIncludesFlag, Object> {
    private String sourceProperty;
    private String targetProperty;
    private String flagValue;

    @Override
    public void initialize(ZeroValueIncludesFlag constraintAnnotation) {
        sourceProperty = constraintAnnotation.sourceProperty();
        targetProperty = constraintAnnotation.targetProperty();
        flagValue = constraintAnnotation.flagValue();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            var sourceValue = (BigDecimal) BeanUtils.getPropertyDescriptor(obj.getClass(), sourceProperty)
                .getReadMethod()
                .invoke(obj);

            var target = (String) BeanUtils.getPropertyDescriptor(obj.getClass(), targetProperty)
                .getReadMethod()
                .invoke(obj);

            if (sourceValue == null || targetProperty == null || BigDecimal.ZERO.compareTo(sourceValue) != 0) {
                return true;
            }

            return target.toLowerCase().contains(flagValue.toLowerCase());
        } catch (Exception e) {
            throw new ValidationException(e);
        }
    }
}
