package com.task.assignment.DTO;

import com.task.assignment.Validation.TaskIdValidationForCreate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestUpdateDTO {
    @TaskIdValidationForCreate
    private String id ;
    private String title ;
    private String description ;
    private Boolean complete ;
}
