package com.finartz.userregistration.controller;


import com.finartz.userregistration.model.User;
import com.finartz.userregistration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        if (userService.userExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
