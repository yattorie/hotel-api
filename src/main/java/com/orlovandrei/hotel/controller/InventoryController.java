package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.entity.inventory.Inventory;
import com.orlovandrei.hotel.service.InventoryService;
import com.orlovandrei.hotel.dto.inventory.InventoryDto;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import com.orlovandrei.hotel.mapper.InventoryMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
@Validated
@Tag(name = "Inventory Controller", description = "Inventory API")
public class InventoryController {

    private final InventoryService inventoryService;

    private final InventoryMapper inventoryMapper;

    public static final String FIND_BY_ID = "/api/v1/inventories/{id}";
    public static final String FIND_ALL = "/api/v1/inventories";
    public static final String CREATE = "/api/v1/inventories";
    public static final String UPDATE = "/api/v1/inventories/{id}";
    public static final String DELETE = "/api/v1/inventories/{id}";

    @GetMapping(FIND_BY_ID)
    @Operation(summary = "Get InventoryDto by id")
    public InventoryDto getById(@PathVariable Long id) {
        Inventory inventory = inventoryService.getById(id);
        return inventoryMapper.toDto(inventory);
    }

    @GetMapping(FIND_ALL)
    @Operation(summary = "Get all inventories")
    public List<InventoryDto> getAll() {
        List<Inventory> inventories = inventoryService.getAll();
        return inventoryMapper.toDto(inventories);
    }

    @PostMapping(CREATE)
    @Operation(summary = "Create a new inventory")
    public InventoryDto create(@Validated(OnCreate.class) @RequestBody InventoryDto inventoryDto) {
        Inventory inventory = inventoryMapper.toEntity(inventoryDto);
        Inventory createdInventory = inventoryService.create(inventory);
        return inventoryMapper.toDto(createdInventory);
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Update an existing inventory")
    public InventoryDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody InventoryDto inventoryDto) {
        Inventory inventory = inventoryMapper.toEntity(inventoryDto);
        Inventory updatedInventory = inventoryService.update(id, inventory);
        return inventoryMapper.toDto(updatedInventory);
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Delete inventory")
    public void deleteById(@PathVariable Long id) {
        inventoryService.delete(id);
    }
}