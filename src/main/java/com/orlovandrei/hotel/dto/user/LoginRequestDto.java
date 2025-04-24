package com.orlovandrei.hotel.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "User login request")
public class LoginRequestDto {

    @Schema(description = "Username", example = "john_doe")
    @NotNull(message = "Username must be not null.")
    private String username;

    @Schema(description = "Password", example = "password123")
    @NotNull(message = "Password must be not null.")
    private String password;
}