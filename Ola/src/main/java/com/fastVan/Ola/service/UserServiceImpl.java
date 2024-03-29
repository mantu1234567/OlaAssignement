package com.fastVan.Ola.service;

import com.fastVan.Ola.DTO.LoginRequest;
import com.fastVan.Ola.DTO.LoginResponse;
import com.fastVan.Ola.customException.PleaseEnterValidEmailOrPassword;
import com.fastVan.Ola.customException.UserAlreadyRegistered;
import com.fastVan.Ola.customException.UserIsNotRegistered;
import com.fastVan.Ola.model.User;
import com.fastVan.Ola.repository.IUserRepo;
import com.fastVan.Ola.service.serviceInterface.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements IUserDetailsService {
    @Autowired
    IUserRepo userRepo;
    @Override
    public ResponseEntity<String> registerUser(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail()).orElse(null);

        if(existingUser == null){
            userRepo.save(user);
            return new ResponseEntity<>("User Register Successfully", HttpStatus.OK);
        }
        throw new UserAlreadyRegistered("User Already Registered");
    }

    @Override
    public ResponseEntity<LoginResponse> userLogin(LoginRequest loginRequest) throws PleaseEnterValidEmailOrPassword {
        User existingUser = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new UserIsNotRegistered("User Not Registered Plz Registered First !!"));

        if(existingUser.getPassword().equals(loginRequest.getPassword())){
            String token = UUID.randomUUID().toString();
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            existingUser.setToken(token);
            loginResponse.setEmail(existingUser.getEmail());
            return new ResponseEntity<>(loginResponse,HttpStatus.OK);
        }
        throw new PleaseEnterValidEmailOrPassword("Please Enter Valid Email Password !!!");
    }
}
