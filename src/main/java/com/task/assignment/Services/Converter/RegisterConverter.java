package com.task.assignment.Services.Converter;

import com.task.assignment.DTO.RegisterDTO;
import com.task.assignment.DTO.UserAuthenticationRequestDTO;
import com.task.assignment.Entity.Role;
import com.task.assignment.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service("registerConverter")
public class RegisterConverter implements Converter<RegisterDTO, User > {
    @Override
    public User convertToEntity(RegisterDTO requestDTO) {
        User user =  new User() ;
        user.setName(requestDTO.getUsername());
        user.setPassword(BCrypt.hashpw( requestDTO.getPassword() , BCrypt.gensalt(12)));
        user.setRole_id(1L);
        return user;
    }

    @Override
    public RegisterDTO convertToDTO(User user) {
        return null;
    }

}
