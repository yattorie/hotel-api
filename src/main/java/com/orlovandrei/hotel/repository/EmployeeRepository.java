package com.orlovandrei.hotel.repository;

import com.orlovandrei.hotel.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
