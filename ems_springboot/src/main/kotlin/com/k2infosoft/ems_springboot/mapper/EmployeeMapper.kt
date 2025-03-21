package com.k2infosoft.ems_springboot.mapper

import com.k2infosoft.ems_springboot.dto.EmployeeDto
import com.k2infosoft.ems_springboot.entity.Employee


object EmployeeMapper {
    fun mapToEmployeeDto(employee: Employee): EmployeeDto {
        return EmployeeDto(
            employee.id,
            employee.firstName,
            employee.lastName,
            employee.email
        )
    }

    fun mapToEmployee(employeeDto: EmployeeDto): Employee {
        return Employee(
            employeeDto.id,
            employeeDto.firstName,
            employeeDto.lastName,
            employeeDto.email
        )
    }
}