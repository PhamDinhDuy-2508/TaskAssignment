package com.task.assignment.Facade;

import com.task.assignment.DTO.RegisterDTO;
import com.task.assignment.DTO.UserAuthenticationRequestDTO;
import com.task.assignment.DTO.UserAuthenticationResponseDTO;

public interface UserFacade {
    UserAuthenticationResponseDTO authentication(UserAuthenticationRequestDTO requestDTO) ;
    void register(RegisterDTO requestDTO) ;
    Boolean checkUserExisted(String name);

}
