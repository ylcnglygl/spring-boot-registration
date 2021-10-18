package com.example.authbackend.dto;

import com.example.authbackend.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserViewDTO implements Serializable {
    private static final long serialVersion =1L;
    private final String firstName;
    private final String lastName;

    private UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of (User user){
        return new UserViewDTO(user.getEmail(), user.getUsername());
    }

}
