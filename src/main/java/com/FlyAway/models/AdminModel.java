package com.FlyAway.models;

public class AdminModel {
    private int adminId;
    private String adminName;
    private String email;
    private String password;
    private String confirmPassword;

    public AdminModel() {
    }

    public AdminModel(int adminId, String adminName, String email, String password, String confirmPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
