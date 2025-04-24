package com.orlovandrei.hotel.dto.maintenance;

import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Schema(description = "Maintenance DTO")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaintenanceDto {

    @Schema(description = "Maintenance id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    Long id;

    @Schema(description = "Maintenance name", example = "Room Cleaning")
    @NotNull(message = "Maintenance name must be not null", groups = {OnUpdate.class, OnCreate.class})
    String name;

    @Schema(description = "Maintenance price", example = "20.0")
    @NotNull(message = "Maintenance price must be not null", groups = {OnUpdate.class, OnCreate.class})
    BigDecimal price;
}
