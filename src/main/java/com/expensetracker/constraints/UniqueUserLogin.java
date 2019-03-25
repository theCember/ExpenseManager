package com.expensetracker.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { UniqueUserLoginValidator.class })
public @interface UniqueUserLogin {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
