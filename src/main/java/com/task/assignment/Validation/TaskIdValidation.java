package com.task.assignment.Validation;

import com.task.assignment.Validation.validate.TaskIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.CLASS)
@Constraint(validatedBy = TaskIdValidator.class)
public @interface TaskIdValidation {
    String message() default "input must be numeric";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
