package com.fastVan.Ola.service.serviceInterface;

import com.fastVan.Ola.DTO.LoginRequest;
import com.fastVan.Ola.DTO.LoginResponse;
import com.fastVan.Ola.customException.PleaseEnterValidEmailOrPassword;
import com.fastVan.Ola.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserDetailsService {
    ResponseEntity<String> registerUser(User user);
    ResponseEntity<LoginResponse> userLogin(LoginRequest loginRequest) throws PleaseEnterValidEmailOrPassword;
}
