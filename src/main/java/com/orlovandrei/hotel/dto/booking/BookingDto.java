package com.orlovandrei.hotel.dto.booking;

import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Booking DTO")
public class BookingDto {

    @Schema(description = "Booking id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    Long id;

    @Schema(description = "Start date of the booking", example = "2025-04-25")
    @NotNull(message = "Start date must be not null", groups = {OnCreate.class, OnUpdate.class})
    LocalDate startDate;

    @Schema(description = "End date of the booking", example = "2025-04-30")
    @NotNull(message = "End date must be not null", groups = {OnCreate.class, OnUpdate.class})
    LocalDate endDate;

    @Schema(description = "User id", example = "1")
    @NotNull(message = "User id must be not null", groups = {OnCreate.class, OnUpdate.class})
    Long userId;

    @Schema(description = "Room id", example = "1")
    @NotNull(message = "Room id must be not null", groups = {OnCreate.class, OnUpdate.class})
    Long roomId;
}