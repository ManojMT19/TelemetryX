package com.telemetryx.api.service;

import com.telemetryx.api.dto.LoginRequestDto;
import com.telemetryx.api.dto.UserRegisterRequestDto;
import com.telemetryx.api.entity.User;
import com.telemetryx.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public void register(UserRegisterRequestDto request)
    {
        User u = new User();

        u.setUsername(request.getUsername());
        u.setEmail(request.getEmail());
        u.setPassword(passwordEncoder.encode(request.getPassword()));

        u.setRole("USER");

        userRepository.save(u);
    }

    public String login(LoginRequestDto request)
    {
        log.info("Login attempt for username : {}",request.getUsername());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername() , request.getPassword()));

        log.info("Login successful for username : {}",request.getUsername());

        return jwtService.generateToken(request.getUsername());
    }
}
