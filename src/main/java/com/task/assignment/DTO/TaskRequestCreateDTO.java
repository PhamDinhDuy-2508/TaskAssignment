package com.task.assignment.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class TaskRequestCreateDTO {
    @NotEmpty(message = "title can not empty")
    private String title ;
    private String description ;
    private Boolean complete ;
}
