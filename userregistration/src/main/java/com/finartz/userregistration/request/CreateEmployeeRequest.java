package com.finartz.userregistration.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long userTitleId;
    private boolean isActive;
}
