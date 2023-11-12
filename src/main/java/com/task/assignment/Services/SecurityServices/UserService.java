package com.task.assignment.Services.SecurityServices;

import com.task.assignment.Configuration.Details.UserInfoDetail;
import com.task.assignment.Entity.User;
import com.task.assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service("userService")
public class UserService implements UserDetailsService {
    private UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username) ;
        if(!user.isPresent()) {
            throw  new UsernameNotFoundException("username is not existed") ;
        }
        return new UserInfoDetail(user.get()) ;
    }
    public UserDetails loadUserById(Long id) {
        Optional<User> user =  userRepository.findById(id) ;
        if(!user.isPresent()) {
            throw  new UsernameNotFoundException("user is not existed") ;
        }
        return  new UserInfoDetail(user.get()) ;
    }
    @Autowired
    public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;
    }

    public UserService() {
    }
}
