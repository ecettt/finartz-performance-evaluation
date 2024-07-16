package com.finartz.userregistration.service;


import com.finartz.userregistration.entity.User;
import com.finartz.userregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> login(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());

        if (userOptional.isPresent()) {
            User foundUser = userOptional.get();
            if (foundUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("Giriş başarılı!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Yanlış şifre!");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Böyle bir kullanıcı mevcut değil!");
        }
    }
}

