package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.dto.user.AuthenticationResponseDto;
import com.orlovandrei.hotel.dto.user.LoginRequestDto;
import com.orlovandrei.hotel.dto.user.RegistrationRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    void register(RegistrationRequestDto request);

    AuthenticationResponseDto authenticate(LoginRequestDto request);

    ResponseEntity<AuthenticationResponseDto> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response);
}
