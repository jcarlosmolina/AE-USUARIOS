package com.keralty.aeusuarios.security;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

import com.keralty.aeusuarios.viewmodel.LoginRequest;
import com.keralty.aeusuarios.viewmodel.UserInfoViewModel;

@ApplicationScoped
public interface UserAuthenticationService {

    Optional<String> login(String username, String password);
    
    Optional<String> login(LoginRequest loginRequest);

    UserInfoViewModel loginAzure(LoginRequest loginRequest);
    void logout(User user);
}
