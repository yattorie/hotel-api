package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.entity.maintenance.Maintenance;
import com.orlovandrei.hotel.service.MaintenanceService;
import com.orlovandrei.hotel.dto.maintenance.MaintenanceDto;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import com.orlovandrei.hotel.mapper.MaintenanceMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Maintenance Controller", description = "Maintenance API")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    private final MaintenanceMapper maintenanceMapper;

    public static final String FIND_BY_ID = "/api/v1/maintenances/{id}";
    public static final String FIND_ALL = "/api/v1/maintenances";
    public static final String CREATE = "/api/v1/maintenances";
    public static final String UPDATE = "/api/v1/maintenances/{id}";
    public static final String DELETE = "/api/v1/maintenances/{id}";

    @GetMapping(FIND_BY_ID)
    @Operation(summary = "Get MaintenanceDto by id")
    public MaintenanceDto getById(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.getById(id);
        return maintenanceMapper.toDto(maintenance);
    }

    @GetMapping(FIND_ALL)
    @Operation(summary = "Get all maintenances")
    public List<MaintenanceDto> getAll() {
        List<Maintenance> maintenances = maintenanceService.getAll();
        return maintenanceMapper.toDto(maintenances);
    }

    @PostMapping(CREATE)
    @Operation(summary = "Create a new maintenance")
    public MaintenanceDto create(@Validated(OnCreate.class) @RequestBody MaintenanceDto maintenanceDto) {
        Maintenance maintenance = maintenanceMapper.toEntity(maintenanceDto);
        Maintenance createdMaintenance = maintenanceService.create(maintenance);
        return maintenanceMapper.toDto(createdMaintenance);
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Update an existing maintenance")
    public MaintenanceDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody MaintenanceDto maintenanceDto) {
        Maintenance maintenance = maintenanceMapper.toEntity(maintenanceDto);
        Maintenance updatedMaintenance = maintenanceService.update(id, maintenance);
        return maintenanceMapper.toDto(updatedMaintenance);
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Delete maintenance")
    public void deleteById(@PathVariable Long id) {
        maintenanceService.delete(id);
    }
}
