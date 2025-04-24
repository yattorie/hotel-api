package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.entity.inventory.Inventory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryService {
    @Transactional(readOnly = true)
    Inventory getById(Long id);

    @Transactional(readOnly = true)
    List<Inventory> getAll();

    @Transactional
    Inventory create(Inventory inventory);

    @Transactional
    Inventory update(Long id, Inventory inventory);

    @Transactional
    void delete(Long id);
}
