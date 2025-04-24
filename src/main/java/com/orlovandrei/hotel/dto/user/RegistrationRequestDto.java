package com.orlovandrei.hotel.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "User registration request")
public class RegistrationRequestDto {

    @Schema(description = "Username", example = "john_doe")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @NotNull(message = "Username must be not null.")
    private String username;

    @Schema(description = "Email", example = "john_doe@example.com")
    @Email(message = "Email must be valid")
    @Size(max = 100, message = "Email must be less than 100 characters")
    @NotNull(message = "Email must be not null.")
    private String email;

    @Schema(description = "Password", example = "password123")
    @NotNull(message = "Password must be not null.")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    private String password;
}
