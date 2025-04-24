package com.orlovandrei.hotel.dto.employee;

import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
@Schema(description = "Employee DTO")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    @Schema(description = "Employee id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    Long id;

    @Schema(description = "Employee firstName", example = "Michael")
    @Length(max = 255, message = "Name must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "First name must be not null", groups = {OnUpdate.class, OnCreate.class})
    String firstName;

    @Schema(description = "Employee lastName", example = "Scott")
    @Length(max = 255, message = "Name must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "Last name must be not null", groups = {OnUpdate.class, OnCreate.class})
    String lastName;

    @Schema(description = "Employee middleName", example = "K")
    @Length(max = 255, message = "Name must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "Middle name must be not null", groups = {OnUpdate.class, OnCreate.class})
    String middleName;

    @Schema(description = "Employee position", example = "Manager")
    @NotNull(message = "Position must be not null", groups = {OnUpdate.class, OnCreate.class})
    String position;

    @Schema(description = "Employee salary", example = "60000.00")
    @NotNull(message = "Salary must be not null", groups = {OnUpdate.class, OnCreate.class})
    BigDecimal salary;

    @Schema(description = "Employee phone", example = "555-1234")
    @NotNull(message = "Phone must be not null", groups = {OnUpdate.class, OnCreate.class})
    String phoneEmployee;
}
