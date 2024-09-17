package com.finartz.userregistration.service;

import com.finartz.userregistration.entity.User;
import com.finartz.userregistration.request.CreateEmployeeRequest;
import com.finartz.userregistration.request.UpdateEmployeeStatusRequest;

public interface AdminService {
    void addEmployee(CreateEmployeeRequest request);
    User updateIsActive(UpdateEmployeeStatusRequest request);
}
