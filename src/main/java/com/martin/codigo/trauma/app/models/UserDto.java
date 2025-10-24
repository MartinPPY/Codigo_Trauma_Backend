package com.martin.codigo.trauma.app.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserDto {

    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private UserRoles role;
    private Boolean available;

    public UserDto() {}

    public UserDto(String name, String email, String phone, UserRoles role, Boolean available) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role.toString();
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvaliable(Boolean available) {
        this.available = available;
    }

    



}
