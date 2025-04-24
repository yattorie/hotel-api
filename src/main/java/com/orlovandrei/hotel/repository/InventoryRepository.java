package com.orlovandrei.hotel.repository;

import com.orlovandrei.hotel.entity.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}