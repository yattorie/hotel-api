package com.orlovandrei.hotel.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Authentication response containing access and update tokens")
public class AuthenticationResponseDto {

    @Schema(description = "Access token")
    private final String accessToken;

    @Schema(description = "Refresh token")
    private final String refreshToken;

    public AuthenticationResponseDto(String token, String refreshToken) {
        this.accessToken = token;
        this.refreshToken = refreshToken;
    }
}