package com.telemetryx.api.service;

import com.telemetryx.api.dto.LoginRequestDto;
import com.telemetryx.api.dto.UserRegisterRequestDto;
import com.telemetryx.api.entity.User;
import com.telemetryx.api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        System.out.println("Inside Login Method");

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(()-> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword() , user.getPassword()))
        {
            throw new RuntimeException(("Invalid Password"));
        }

        return "Login Successfully";

    }
}
