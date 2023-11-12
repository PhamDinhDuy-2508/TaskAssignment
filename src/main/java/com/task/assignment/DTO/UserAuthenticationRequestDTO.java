package com.task.assignment.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class UserAuthenticationRequestDTO {
    @NotEmpty(message = "username must be filled" )
    private  String username ;

    @NotEmpty(message = "password must be filled" )
    private  String password ;

}
