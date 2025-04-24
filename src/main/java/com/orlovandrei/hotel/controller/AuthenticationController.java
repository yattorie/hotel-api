package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.service.AuthenticationService;
import com.orlovandrei.hotel.service.UserService;
import com.orlovandrei.hotel.dto.user.AuthenticationResponseDto;
import com.orlovandrei.hotel.dto.user.LoginRequestDto;
import com.orlovandrei.hotel.dto.user.RegistrationRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Auth Controller", description = "Auth API")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    public static final String REGISTRATION = "/api/v1/auth/registration";
    public static final String LOGIN = "/api/v1/auth/login";
    public static final String REFRESH_TOKEN = "/api/v1/auth/refresh_token";

    @PostMapping(REGISTRATION)
    @Operation(summary = "Registration")
    public ResponseEntity<String> register(
            @Valid
            @RequestBody RegistrationRequestDto registrationDto) {

        if(userService.existsByUsername(registrationDto.getUsername())) {
            return ResponseEntity.badRequest().body("The username is already taken");
        }

        if(userService.existsByEmail(registrationDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email already taken");
        }

        authenticationService.register(registrationDto);

        return ResponseEntity.ok("Registration was successful");
    }

    @PostMapping(LOGIN)
    @Operation(summary = "Login")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@Valid @RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping(REFRESH_TOKEN)
    @Operation(summary = "Refresh token")
    public ResponseEntity<AuthenticationResponseDto> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) {

        return authenticationService.refreshToken(request, response);
    }
}