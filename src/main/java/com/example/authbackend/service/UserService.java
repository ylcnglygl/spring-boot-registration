package com.example.authbackend.service;

import com.example.authbackend.dto.UserCreateDTO;
import com.example.authbackend.dto.UserLoginDTO;
import com.example.authbackend.dto.UserViewDTO;

public interface UserService {
    UserViewDTO getUserById(Long id);
    UserViewDTO createUser(UserCreateDTO userCreateDTO);
    UserLoginDTO loginUser(UserLoginDTO userLoginDTO);
}
