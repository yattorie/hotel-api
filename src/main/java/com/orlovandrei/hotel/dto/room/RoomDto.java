package com.orlovandrei.hotel.dto.room;

import com.orlovandrei.hotel.entity.room.RoomStatus;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Room DTO")
public class RoomDto {

    @Schema(description = "Room id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    Long id;

    @Schema(description = "Room number", example = "101")
    @NotNull(message = "Room number must be not null", groups = {OnUpdate.class, OnCreate.class})
    String roomNumber;

    @Schema(description = "Room number", example = "Single")
    @NotNull(message = "Room type must be not null", groups = {OnUpdate.class, OnCreate.class})
    String roomType;

    @Schema(description = "Amount", example = "1")
    @NotNull(message = "Amount must be not null", groups = {OnUpdate.class, OnCreate.class})
    int amount;

    @Schema(description = "Price", example = "50.0")
    @NotNull(message = "Price must be not null", groups = {OnUpdate.class, OnCreate.class})
    BigDecimal price;

    @Schema(description = "Description", example = "Standard single room")
    @NotNull(message = "Description must be not null", groups = {OnUpdate.class, OnCreate.class})
    String description;

    @Schema(description = "Room status", example = "AVAILABLE")
    @NotNull(message = "Status must be not null", groups = {OnUpdate.class, OnCreate.class})
    RoomStatus status;
}
