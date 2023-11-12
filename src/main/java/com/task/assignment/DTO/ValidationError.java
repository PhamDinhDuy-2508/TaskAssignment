package com.task.assignment.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ValidationError {
    String name;
    List<FieldError> fieldErrorList;
}
