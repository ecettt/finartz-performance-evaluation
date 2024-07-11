package com.finartz.userregistration.service;


import com.finartz.userregistration.model.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public void registerUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public boolean userExists(String username) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }
}

