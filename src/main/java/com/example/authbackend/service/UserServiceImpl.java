package com.example.authbackend.service;

import com.example.authbackend.dto.UserCreateDTO;
import com.example.authbackend.dto.UserLoginDTO;
import com.example.authbackend.dto.UserViewDTO;
import com.example.authbackend.exception.NotFoundException;
import com.example.authbackend.model.User;
import com.example.authbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserViewDTO getUserById(Long id) {
        final User user =  userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
   //     String encodedPassword = this.passwordEncoder.encode(userCreateDTO.getPassword());
      //  userCreateDTO.setPassword(encodedPassword);

        final User user = userRepository.save(new User(userCreateDTO.getEmail(), userCreateDTO.getUsername(), userCreateDTO.getPassword()));
        return UserViewDTO.of(user);
    }

    @Override
    public UserLoginDTO loginUser(UserLoginDTO userLoginDTO) {
    if(userRepository.findByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword()) != null){
        return new UserLoginDTO(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }else{
        return null;
    }
    }
}
