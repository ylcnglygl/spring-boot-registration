package com.example.authbackend.dto;

import lombok.Data;
@Data
public class UserCreateDTO {
    private String email;
    private String username;
    private String password;
}
