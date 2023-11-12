package com.task.assignment.Services.HandleException.HandleExceptionImpl;

import com.task.assignment.DTO.FieldError;
import com.task.assignment.DTO.ValidationError;
import com.task.assignment.Services.HandleException.HandleException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
@Service
public class HandleExceptionImpl implements HandleException {
    @Override
    public ValidationError handelException(BindingResult bindingResult) {
        List<FieldError> fieldErrorList =  new ArrayList<>() ;
        for(org.springframework.validation.FieldError error : bindingResult.getFieldErrors()) {
            FieldError fieldError =  new FieldError(error.getField(),error.getDefaultMessage()) ;
            fieldErrorList.add(fieldError) ;
        }
        return new ValidationError("Error" , fieldErrorList);
    }
}
