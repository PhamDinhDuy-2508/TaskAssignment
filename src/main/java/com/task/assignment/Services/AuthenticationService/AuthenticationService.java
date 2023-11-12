package com.task.assignment.Services.AuthenticationService;

import com.task.assignment.Configuration.Details.UserInfoDetail;
import com.task.assignment.Exception.TaskException;
import com.task.assignment.Exception.UserAuthenticationException;
import com.task.assignment.DTO.UserAuthenticationRequestDTO;
import com.task.assignment.Entity.Role;
import com.task.assignment.Entity.User;
import com.task.assignment.Repository.RoleRepository;
import com.task.assignment.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service("authenticationService")
public class AuthenticationService implements AuthenticationServices {
    Logger logger = LoggerFactory.getLogger(AuthenticationServices.class);
    @Autowired
    private AuthenticationProvider authenticationProvider ;
    private UserRepository<User> userRepository ;
    private RoleRepository roleRepository ;
    @Override
    public UserInfoDetail authentication(UserAuthenticationRequestDTO userAuthenticationRequestDTO) {
        try {
            Authentication authentication = authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userAuthenticationRequestDTO.getUsername() ,
                            userAuthenticationRequestDTO.getPassword()
                    )
            ) ;
            if(authentication.getPrincipal() instanceof UserInfoDetail) {
                return (UserInfoDetail) authentication.getPrincipal() ;
            }
            else {
                throw new UserAuthenticationException("Can't Authentication");
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            throw new UserAuthenticationException("Can't Authentication");
        }
    }
    @Override
    @Async
    public void register(User user) {
        try {
            Role role =  roleRepository.findById(1L).get() ;
            user.setRole(role);
            role.setUser(Collections.singleton(user));
            roleRepository.save(role) ;
        }
        catch (Exception e) {
            throw new TaskException("Can't not register this account") ;
        }
    }
    @Override
    public User getUser(String name) {
        return userRepository.findByName(name).orElse(null) ;
    }

    @Autowired
    @Qualifier("userRepository")
    private void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
