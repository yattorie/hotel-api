package com.orlovandrei.hotel.service.impl;

import com.orlovandrei.hotel.entity.inventory.Inventory;
import com.orlovandrei.hotel.entity.exception.ResourceNotFoundException;
import com.orlovandrei.hotel.repository.InventoryRepository;
import com.orlovandrei.hotel.service.InventoryService;
import com.orlovandrei.hotel.utils.ServiceMessages;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println(ServiceMessages.INVENTORY_CONSTRUCTED.getMessage());
    }

    @Override
    @Transactional(readOnly = true)
    public Inventory getById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.INVENTORY_NOT_FOUND.getMessage() + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    @Override
    @Transactional
    public Inventory create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    @Transactional
    public Inventory update(Long id, Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.INVENTORY_NOT_FOUND.getMessage() + id));
        existingInventory.setName(inventory.getName());
        existingInventory.setQuantity(inventory.getQuantity());
        existingInventory.setCondition(inventory.getCondition());
        return inventoryRepository.save(existingInventory);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new ResourceNotFoundException(ServiceMessages.INVENTORY_NOT_FOUND.getMessage() + id);
        }
        inventoryRepository.deleteById(id);
    }
}