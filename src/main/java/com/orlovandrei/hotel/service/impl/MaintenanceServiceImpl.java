package com.orlovandrei.hotel.service.impl;

import com.orlovandrei.hotel.entity.exception.ResourceNotFoundException;
import com.orlovandrei.hotel.entity.maintenance.Maintenance;
import com.orlovandrei.hotel.repository.MaintenanceRepository;
import com.orlovandrei.hotel.service.MaintenanceService;
import com.orlovandrei.hotel.utils.ServiceMessages;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println(ServiceMessages.MAINTENANCE_CONSTRUCTED.getMessage());
    }

    @Override
    @Transactional(readOnly = true)
    public Maintenance getById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.MAINTENANCE_NOT_FOUND.getMessage() + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    @Transactional
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    @Transactional
    public Maintenance update(Long id, Maintenance maintenance) {
        Maintenance existingMaintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.MAINTENANCE_NOT_FOUND.getMessage() + id));
        existingMaintenance.setName(maintenance.getName());
        existingMaintenance.setPrice(maintenance.getPrice());
        return maintenanceRepository.save(existingMaintenance);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new ResourceNotFoundException(ServiceMessages.MAINTENANCE_NOT_FOUND.getMessage() + id);
        }
        maintenanceRepository.deleteById(id);
    }
}
