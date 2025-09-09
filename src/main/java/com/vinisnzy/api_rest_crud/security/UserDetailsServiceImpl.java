package com.vinisnzy.api_rest_crud.security;

import com.vinisnzy.api_rest_crud.exceptions.ResourceNotFoundException;
import com.vinisnzy.api_rest_crud.model.User;
import com.vinisnzy.api_rest_crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username).orElseThrow(
                () -> new ResourceNotFoundException("User not found with email: " + username)
        );
        return new UserDetailsImpl(user);
    }
}
