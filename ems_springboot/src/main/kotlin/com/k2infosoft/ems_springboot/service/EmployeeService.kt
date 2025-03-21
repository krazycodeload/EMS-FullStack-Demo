package com.k2infosoft.ems_springboot.service

import com.k2infosoft.ems_springboot.dto.EmployeeDto



interface EmployeeService {
    fun createEmployee(employeeDto: EmployeeDto): EmployeeDto

    fun getEmployeeById(employeeId: Long): EmployeeDto

    fun getAllEmployees(): MutableList<EmployeeDto>

    fun updateEmployee(employeeId: Long, updatedEmployee: EmployeeDto): EmployeeDto

    fun deleteEmployee(employeeId: Long)
}