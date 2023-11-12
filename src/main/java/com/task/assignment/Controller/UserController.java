package com.task.assignment.Controller;

import com.task.assignment.DTO.RegisterDTO;
import com.task.assignment.DTO.UserAuthenticationRequestDTO;
import com.task.assignment.Facade.UserFacade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserFacade userFacade;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody UserAuthenticationRequestDTO requestDTO) {
        return ResponseEntity.ok(userFacade.authentication(requestDTO));
    }

    @PostMapping("/auth/register")
    public void register(@RequestBody @Valid RegisterDTO requestDTO) {
        userFacade.register(requestDTO);
    }

    @Autowired
    @Qualifier("userFacade")
    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
