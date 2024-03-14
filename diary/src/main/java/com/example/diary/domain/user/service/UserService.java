package com.example.diary.domain.user.service;

import com.example.diary.domain.user.controller.request.LoginRequest;
import com.example.diary.domain.user.controller.request.SignupRequest;
import com.example.diary.domain.user.controller.response.TokenResponse;
import com.example.diary.domain.user.domain.User;
import com.example.diary.domain.user.domain.repository.UserRepository;
import com.example.diary.domain.user.exception.NotMatchesPasswordException;
import com.example.diary.domain.user.exception.UserNotFoundException;
import com.example.diary.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void signup(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserNotFoundException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }

    @Transactional
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw NotMatchesPasswordException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.createAccessToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}