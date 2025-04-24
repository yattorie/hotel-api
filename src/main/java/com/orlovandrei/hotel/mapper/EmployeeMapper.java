package com.orlovandrei.hotel.mapper;

import com.orlovandrei.hotel.entity.employee.Employee;
import com.orlovandrei.hotel.dto.employee.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends Mappable<Employee, EmployeeDto>{
}
