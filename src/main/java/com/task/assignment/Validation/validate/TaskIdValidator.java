package com.task.assignment.Validation.validate;

import com.task.assignment.Validation.TaskIdValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TaskIdValidator implements ConstraintValidator<TaskIdValidation , String> {

    @Override
    public void initialize(TaskIdValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "\\d+";
        return s.matches(regex);
    }
}
