package com.vinisnzy.api_rest_crud.service;

import com.vinisnzy.api_rest_crud.config.SecurityConfig;
import com.vinisnzy.api_rest_crud.dto.LoginRequestDTO;
import com.vinisnzy.api_rest_crud.dto.RegisterRequestDTO;
import com.vinisnzy.api_rest_crud.dto.TokenResponseDTO;
import com.vinisnzy.api_rest_crud.enums.RoleName;
import com.vinisnzy.api_rest_crud.exceptions.EmailAlreadyExistsException;
import com.vinisnzy.api_rest_crud.model.User;
import com.vinisnzy.api_rest_crud.repository.UserRepository;
import com.vinisnzy.api_rest_crud.security.JwtTokenService;
import com.vinisnzy.api_rest_crud.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;

    private final RoleService roleService;

    private final JwtTokenService tokenService;

    private final AuthenticationManager authenticationManager;

    private final SecurityConfig securityConfig;

    public void register(RegisterRequestDTO data) {
        Optional<User> existingUser = repository.findByEmail(data.email());
        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException("User with this email already exists");
        }
        User user = User.builder()
                .email(data.email())
                .password(securityConfig.passwordEncoder().encode(data.password()))
                .roles(List.of(roleService.getRoleByName(RoleName.ROLE_USER)))
                .build();
        repository.save(user);
    }

    public TokenResponseDTO login(LoginRequestDTO data) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();

        return new TokenResponseDTO(tokenService.generateToken(user));
    }
}
