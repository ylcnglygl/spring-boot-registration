package com.example.authbackend.dto;

import lombok.Data;
@Data
public class UserLoginDTO {
    private String username;
    private String password;

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
