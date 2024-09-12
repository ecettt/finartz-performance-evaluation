package com.finartz.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Role;
import com.finartz.userregistration.entity.User;
import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.exception.UserAlreadyExistsException;
import com.finartz.userregistration.repository.UserRepository;
import com.finartz.userregistration.repository.UserTitleRepository;
import com.finartz.userregistration.request.CreateEmployeeRequest;
import com.finartz.userregistration.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private UserTitleRepository userTitleRepository;

    @Override
    public void addEmployee(CreateEmployeeRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists.");
        }

        UserTitle userTitle = userTitleRepository.findById(request.getUserTitleId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User Title ID"));

        
        var employee = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(null)
        .role(Role.USER)
        .userTitle(userTitle)
        .build();

        userRepository.save(employee);
    }
}
