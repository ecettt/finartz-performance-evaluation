package com.finartz.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.entity.User;
import com.finartz.userregistration.request.CreateEmployeeRequest;
import com.finartz.userregistration.request.UpdateEmployeeStatusRequest;
import com.finartz.userregistration.service.AdminService;

@RestController
@RequestMapping("/api/employees")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody CreateEmployeeRequest request) {
        adminService.addEmployee(request);
        return ResponseEntity.ok("Employee added.");
    }

    @PutMapping("/{employeeId}/status")
    public ResponseEntity<User> updateIsActive(@PathVariable Long employeeId, @RequestBody UpdateEmployeeStatusRequest request) {
        User updatedUser = adminService.updateIsActive(employeeId, request);
        return ResponseEntity.ok(updatedUser);
    }
}
