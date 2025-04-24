package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.entity.employee.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService{
    @Transactional(readOnly = true)
    Employee getById(Long id);

    @Transactional(readOnly = true)
    List<Employee> getAll();

    @Transactional
    Employee create(Employee employee);

    @Transactional
    Employee update(Long id, Employee employee);

    @Transactional
    void delete(Long id);
}
