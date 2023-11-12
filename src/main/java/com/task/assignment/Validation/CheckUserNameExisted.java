package com.task.assignment.Validation;

import com.task.assignment.Validation.validate.RegisterValidate;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegisterValidate.class)
public @interface CheckUserNameExisted {
    String message() default "user has been existed" ;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
