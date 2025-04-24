package com.orlovandrei.hotel.dto.review;

import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Review DTO")
public class ReviewDto {

    @Schema(description = "Review id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    Long id;

    @Schema(description = "Comment", example = "Great room!")
    @NotNull(message = "Comment must be not null", groups = {OnCreate.class, OnUpdate.class})
    String comment;

    @Schema(description = "Rating", example = "5")
    @NotNull(message = "Rating must be not null", groups = {OnCreate.class, OnUpdate.class})
    int rating;

    @Schema(description = "User id", example = "1")
    @NotNull(message = "User id must be not null", groups = {OnCreate.class, OnUpdate.class})
    Long userId;

    @Schema(description = "Room id", example = "1")
    @NotNull(message = "Room id must be not null", groups = {OnCreate.class, OnUpdate.class})
    Long roomId;
}