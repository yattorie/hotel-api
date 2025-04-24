package com.orlovandrei.hotel.dto.inventory;

import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Schema(description = "Inventory DTO")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryDto {

    @Schema(description = "Inventory id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    Long id;

    @Schema(description = "Inventory name", example = "Bed")
    @NotNull(message = "Name must be not null", groups = {OnUpdate.class, OnCreate.class})
    String name;

    @Schema(description = "Inventory quantity", example = "20")
    @NotNull(message = "Quantity must be not null", groups = {OnUpdate.class, OnCreate.class})
    int quantity;

    @Schema(description = "Inventory condition", example = "Good")
    @NotNull(message = "Condition must be not null", groups = {OnUpdate.class, OnCreate.class})
    String condition;
}