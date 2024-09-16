package com.finartz.userregistration.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.exception.UserAlreadyExistsException;
import com.finartz.userregistration.repository.UserRepository;
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


    @Override
    public JwtAuthenticationResponse register(RegisterRequest request) {
        // Check if a user with the provided email already exists
        var existingUser = userRepository.findByEmail(request.getEmail());

        // If the user is found, update their password
        if(existingUser.isPresent()) {
            var user = existingUser.get();
            if(user.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(request.getPassword()));

                // Save updated user
                userRepository.save(user);

                // Generate JWT token for the user
                var jwt = jwtService.generateToken(user);
                
                return JwtAuthenticationResponse.builder().token(jwt).build();
            }
            else {
                throw new UserAlreadyExistsException("This user already exists.");
            }
            
        } else  {
            throw new ResourceNotFoundException("Email does not exist.");
        }
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