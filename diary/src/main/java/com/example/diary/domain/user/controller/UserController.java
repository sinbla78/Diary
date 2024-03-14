package com.example.diary.domain.user.controller;

import com.example.diary.domain.user.controller.request.LoginRequest;
import com.example.diary.domain.user.controller.request.SignupRequest;
import com.example.diary.domain.user.controller.response.TokenResponse;
import com.example.diary.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request){
        userService.signup(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request){
        return userService.login(request);
    }
}
