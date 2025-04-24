package com.orlovandrei.hotel.repository;

import com.orlovandrei.hotel.entity.maintenance.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
