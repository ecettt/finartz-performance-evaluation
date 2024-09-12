package com.finartz.userregistration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.finartz.userregistration.entity.Role;
import com.finartz.userregistration.entity.User;
import com.finartz.userregistration.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0) {
            createUser("Admin", "admin", "example@finartz.com", "12345", Role.ADMIN);
        }
    }

    private void createUser(String firstName, String lastName, String email, String password, Role role) {
        String encodedPassword = passwordEncoder.encode(password);

        User user = User.builder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(encodedPassword)
        .role(role)
        .build();

        userRepository.save(user);
    } 
}
