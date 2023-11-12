package com.task.assignment.Validation;

import com.task.assignment.Validation.validate.TaskIdValidateForCreate;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TaskIdValidateForCreate.class)
public @interface TaskIdValidationForCreate {
    String message() default "input must be numeric";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
