package com.gabriel.springrestspecialist.core.validation;

import com.gabriel.springrestspecialist.core.validation.validator.ZeroValueIncludesFlagValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ZeroValueIncludesFlagValidator.class })
public @interface ZeroValueIncludesFlag {
    String message() default "The name must contain flag '[Free Delivery]'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String sourceProperty();

    String targetProperty();

    String flagValue();
}
