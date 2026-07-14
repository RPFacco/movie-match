package com.rpfacco.moviematch.controller;

import com.rpfacco.moviematch.security.dto.LoginRequestDTO;
import com.rpfacco.moviematch.security.dto.LoginResponseDTO;
import com.rpfacco.moviematch.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO data) {
        return ResponseEntity.ok(authService.login(data));
    }
}