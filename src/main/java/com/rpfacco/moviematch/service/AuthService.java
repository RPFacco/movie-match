package com.rpfacco.moviematch.service;

import com.rpfacco.moviematch.domain.user.User;
import com.rpfacco.moviematch.repository.UserRepository;
import com.rpfacco.moviematch.security.JwtService;
import com.rpfacco.moviematch.security.dto.LoginRequestDTO;
import com.rpfacco.moviematch.security.dto.LoginResponseDTO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO data) {
        User user = userRepository.findByEmail(data.email())
                .orElseThrow(() -> new BadCredentialsException("Credenciais inválidas"));

        if (!passwordEncoder.matches(data.password(), user.getPassword())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponseDTO(token);
    }
}