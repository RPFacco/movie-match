package com.rpfacco.moviematch.service;

import com.rpfacco.moviematch.domain.user.User;
import com.rpfacco.moviematch.domain.user.dto.UserRequestDTO;
import com.rpfacco.moviematch.domain.user.dto.UserResponseDTO;
import com.rpfacco.moviematch.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO createUser(UserRequestDTO data) {
        User newUser = new User();
        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(passwordEncoder.encode(data.password()));

        User savedUser = repository.save(newUser);

        return toResponseDTO(savedUser);
    }

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

}
