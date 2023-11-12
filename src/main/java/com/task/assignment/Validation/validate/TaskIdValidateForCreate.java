package com.task.assignment.Validation.validate;

import com.task.assignment.Validation.TaskIdValidationForCreate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaskIdValidateForCreate implements ConstraintValidator<TaskIdValidationForCreate, String> {

    @Override
    public void initialize(TaskIdValidationForCreate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "\\d+";
        if(s == null) {
            return true ;
        }
        return s.matches(regex);
    }
}
