package com.orlovandrei.hotel.mapper;

import com.orlovandrei.hotel.entity.inventory.Inventory;
import com.orlovandrei.hotel.dto.inventory.InventoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryMapper extends Mappable<Inventory, InventoryDto> {
}