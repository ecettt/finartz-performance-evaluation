package com.finartz.userregistration.request;

public class UpdateEmployeeStatusRequest {
    private Long userId;
    private boolean isActive;

    public void setIsActive(boolean isActive, Long userId) {
        this.isActive = isActive;
        this.userId = userId;
    }

     // Getters and Setters
     public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
