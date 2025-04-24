package com.orlovandrei.hotel.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "User DTO")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    @Schema(description = "User id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    Long id;

    @Schema(description = "User name", example = "John Doe")
    @NotNull(message = "Name must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Name must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    String username;

    @Schema(description = "User email", example = "johndoe@mail.ru")
    @NotNull(message = "User email must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "User email must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    String email;

    @Schema(description = "User crypted password", example = "$2a$12$HQecBE4TRLF9QuAHRSubYuEPgrPQ1wrcux/CpSdvxy5QIWkMEujYW")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnUpdate.class, OnCreate.class})
    String password;

}
