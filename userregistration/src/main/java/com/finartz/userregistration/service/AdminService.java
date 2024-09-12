package com.finartz.userregistration.service;

import com.finartz.userregistration.request.CreateEmployeeRequest;

public interface AdminService {
    void addEmployee(CreateEmployeeRequest request);
}
