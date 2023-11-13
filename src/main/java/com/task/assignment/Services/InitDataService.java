package com.task.assignment.Services;

import com.task.assignment.Entity.Role;
import com.task.assignment.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class InitDataService implements ApplicationRunner {
    @Autowired
    private  RoleRepository roleRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleAD =  new Role() ;
        roleAD.setRole_id(1L);
        roleAD.setName("ADMIN");
        Role role =  new Role() ;
        role.setRole_id(2L);
        role.setName("USER");
        roleRepository.save(roleAD);
        roleRepository.save(role);
    }
}
