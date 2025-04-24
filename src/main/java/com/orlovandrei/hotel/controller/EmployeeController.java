package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.entity.employee.Employee;
import com.orlovandrei.hotel.service.EmployeeService;
import com.orlovandrei.hotel.dto.employee.EmployeeDto;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import com.orlovandrei.hotel.mapper.EmployeeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Employee Controller", description = "Employee API")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    public static final String FIND_BY_ID = "/api/v1/employees/{id}";
    public static final String FIND_ALL = "/api/v1/employees";
    public static final String CREATE = "/api/v1/employees";
    public static final String UPDATE = "/api/v1/employees/{id}";
    public static final String DELETE = "/api/v1/employees/{id}";

    @GetMapping(FIND_BY_ID)
    @Operation(summary = "Get EmployeeDto by id")
    public EmployeeDto getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return employeeMapper.toDto(employee);
    }

    @GetMapping(FIND_ALL)
    @Operation(summary = "Get all employees")
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeService.getAll();
        return employeeMapper.toDto(employees);
    }

    @PostMapping(CREATE)
    @Operation(summary = "Create a new employee")
    public EmployeeDto create(@Validated(OnCreate.class) @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        Employee createdEmployee = employeeService.create(employee);
        return employeeMapper.toDto(createdEmployee);
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Update an existing employee")
    public EmployeeDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        Employee updatedEmployee = employeeService.update(id, employee);
        return employeeMapper.toDto(updatedEmployee);
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Delete employee")
    public void deleteById(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
