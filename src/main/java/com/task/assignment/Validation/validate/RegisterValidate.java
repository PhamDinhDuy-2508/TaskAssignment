package com.task.assignment.Validation.validate;

import com.task.assignment.Facade.UserFacade;
import com.task.assignment.Validation.CheckUserNameExisted;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterValidate implements ConstraintValidator<CheckUserNameExisted, String> {
    private UserFacade userFacade ;


    @Override
    public void initialize(CheckUserNameExisted constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userFacade.checkUserExisted(s) ;
    }

    @Autowired
    public void setUserService(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
