package com.fastVan.Ola.controller;

import com.fastVan.Ola.DTO.LoginRequest;
import com.fastVan.Ola.DTO.LoginResponse;
import com.fastVan.Ola.customException.PleaseEnterValidEmailOrPassword;
import com.fastVan.Ola.model.User;
import com.fastVan.Ola.service.serviceInterface.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserDetailsService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")

    public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest) throws PleaseEnterValidEmailOrPassword {
        return userService.userLogin(loginRequest);
    }
}
