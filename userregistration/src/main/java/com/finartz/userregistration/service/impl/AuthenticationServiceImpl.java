package com.finartz.userregistration.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Role;
import com.finartz.userregistration.entity.User;
import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.exception.UserAlreadyExistsException;
import com.finartz.userregistration.repository.UserRepository;
import com.finartz.userregistration.repository.UserTitleRepository;
import com.finartz.userregistration.request.LoginRequest;
import com.finartz.userregistration.request.RegisterRequest;
import com.finartz.userregistration.response.JwtAuthenticationResponse;
import com.finartz.userregistration.service.AuthenticationService;
import com.finartz.userregistration.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserTitleRepository userTitleRepository;


    @Override
    public JwtAuthenticationResponse register(RegisterRequest request) {
        //Check if a user with the provided email already exists
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists.");
        }
        
          // Retrieve the UserTitle entity using the provided ID
        UserTitle userTitle = userTitleRepository.findById(request.getUserTitleId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User Title ID"));

        //Create a new user
        var user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .userTitle(userTitle)
        .build();

        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
       
        var user = userRepository.findByEmail(request.getEmail())
                                 .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid email or password");
        }
        
    }
}