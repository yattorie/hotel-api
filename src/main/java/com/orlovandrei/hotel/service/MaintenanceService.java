package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.entity.maintenance.Maintenance;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MaintenanceService {
    @Transactional(readOnly = true)
    Maintenance getById(Long id);

    @Transactional(readOnly = true)
    List<Maintenance> getAll();

    @Transactional
    Maintenance create(Maintenance maintenance);

    @Transactional
    Maintenance update(Long id, Maintenance maintenance);

    @Transactional
    void delete(Long id);
}
