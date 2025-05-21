package com.gabriel.springrestspecialist.core.validation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.PositiveOrZero;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@PositiveOrZero
public @interface DeliveryFee {
    @OverridesAttribute(constraint = PositiveOrZero.class, name = "message")
    String message() default "{DeliveryFee}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
