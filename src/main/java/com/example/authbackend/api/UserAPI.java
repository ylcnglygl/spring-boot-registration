package com.example.authbackend.api;

import com.example.authbackend.dto.UserCreateDTO;
import com.example.authbackend.dto.UserLoginDTO;
import com.example.authbackend.dto.UserViewDTO;
import com.example.authbackend.service.UserService;
import com.example.authbackend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserAPI {

    private final UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User Created."));
    }
    @PostMapping("v1/user/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userCreateDTO){
        final UserLoginDTO user = userService.loginUser(userCreateDTO);
        if(user != null){
            return ResponseEntity.ok(new GenericResponse("User Logged In."));
        }
        return ResponseEntity.ok(new GenericResponse("Username or password is incorrect."));
    }

}
