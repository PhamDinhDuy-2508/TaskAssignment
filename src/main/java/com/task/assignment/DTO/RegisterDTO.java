package com.task.assignment.DTO;

import com.task.assignment.Validation.CheckUserNameExisted;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class RegisterDTO {
    @NotEmpty(message = "username must be filled" )
    @CheckUserNameExisted(message = "username has been existed")
    private  String username ;

    @NotEmpty(message = "message must be filled")
    private  String password ;
}
