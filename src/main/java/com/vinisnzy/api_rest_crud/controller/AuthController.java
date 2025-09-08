package com.vinisnzy.api_rest_crud.controller;

import com.vinisnzy.api_rest_crud.dto.LoginRequestDTO;
import com.vinisnzy.api_rest_crud.dto.RegisterRequestDTO;
import com.vinisnzy.api_rest_crud.dto.TokenResponseDTO;
import com.vinisnzy.api_rest_crud.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequestDTO data) {
        service.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@Valid @RequestBody LoginRequestDTO data) {
        TokenResponseDTO token = service.login(data);
        return ResponseEntity.ok().body(token);
    }
}
