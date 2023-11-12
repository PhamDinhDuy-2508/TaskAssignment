package com.task.assignment.Services.Converter;

import com.task.assignment.Configuration.Details.UserInfoDetail;
import com.task.assignment.DTO.UserAuthenticationResponseDTO;
import com.task.assignment.Jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authConverter")
public class AuthConverter implements Converter<UserAuthenticationResponseDTO , UserInfoDetail> {
    private JwtProvider jwtProvider ;
    @Override
    public UserInfoDetail convertToEntity(UserAuthenticationResponseDTO userAuthenticationResponseDTO) {
        return null;
    }
    @Override
    public UserAuthenticationResponseDTO convertToDTO(UserInfoDetail userDetails) {
        UserAuthenticationResponseDTO userAuthenticationResponseDTO =  new UserAuthenticationResponseDTO() ;
        String jwt = jwtProvider.generateToken(userDetails) ;
        userAuthenticationResponseDTO.setJwt(jwt);
        return userAuthenticationResponseDTO;
    }
    @Autowired
    public void setJwtProvider(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }
}
