package com.task.assignment.Services.AuthenticationService;

import com.task.assignment.Configuration.Details.UserInfoDetail;
import com.task.assignment.DTO.UserAuthenticationRequestDTO;
import com.task.assignment.Entity.User;

public interface AuthenticationServices {
    UserInfoDetail authentication(UserAuthenticationRequestDTO userAuthenticationRequestDTO) ;
    void register (User user) ;

    User getUser(String name) ;

}
