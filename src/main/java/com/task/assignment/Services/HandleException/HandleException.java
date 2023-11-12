package com.task.assignment.Services.HandleException;

import com.task.assignment.DTO.ValidationError;
import org.springframework.validation.BindingResult;

public interface HandleException {
    ValidationError handelException(BindingResult bindingResult) ;
}
