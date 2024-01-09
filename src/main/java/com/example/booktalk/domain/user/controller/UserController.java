package com.example.booktalk.domain.user.controller;

import com.example.booktalk.domain.user.dto.request.LoginReqDto;
import com.example.booktalk.domain.user.dto.request.ProfileReqdto;
import com.example.booktalk.domain.user.dto.request.SignupReqDto;
import com.example.booktalk.domain.user.dto.response.UserResDto;
import com.example.booktalk.domain.user.service.UserService;
import com.example.booktalk.global.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResDto> signup(@Valid @RequestBody SignupReqDto req) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(userService.signup(req));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResDto> login(@RequestBody LoginReqDto req, HttpServletResponse res) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.login(req, res));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResDto> updateProfile(@PathVariable Long userId, @RequestBody ProfileReqdto req, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.updateProfile(userId,req,userDetails));
    }
}