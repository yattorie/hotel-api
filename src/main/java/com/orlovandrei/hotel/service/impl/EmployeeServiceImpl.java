package com.orlovandrei.hotel.service.impl;

import com.orlovandrei.hotel.entity.employee.Employee;
import com.orlovandrei.hotel.entity.exception.ResourceNotFoundException;
import com.orlovandrei.hotel.repository.EmployeeRepository;
import com.orlovandrei.hotel.service.EmployeeService;
import com.orlovandrei.hotel.utils.ServiceMessages;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println(ServiceMessages.EMPLOYEE_CONSTRUCTED.getMessage());
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.EMPLOYEE_NOT_FOUND.getMessage() + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee update(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.EMPLOYEE_NOT_FOUND.getMessage() + id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setMiddleName(employee.getMiddleName());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setPhoneEmployee(employee.getPhoneEmployee());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException(ServiceMessages.EMPLOYEE_NOT_FOUND.getMessage() + id);
        }
        employeeRepository.deleteById(id);
    }
}
