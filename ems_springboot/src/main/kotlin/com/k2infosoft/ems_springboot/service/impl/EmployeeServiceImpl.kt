package com.k2infosoft.ems_springboot.service.impl

import com.k2infosoft.ems_springboot.dto.EmployeeDto
import com.k2infosoft.ems_springboot.entity.Employee
import com.k2infosoft.ems_springboot.exception.ResourceNotFoundException
import com.k2infosoft.ems_springboot.mapper.EmployeeMapper.mapToEmployee
import com.k2infosoft.ems_springboot.mapper.EmployeeMapper.mapToEmployeeDto
import com.k2infosoft.ems_springboot.repository.EmployeeRepository
import com.k2infosoft.ems_springboot.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Supplier
import java.util.stream.Collectors


@Service
class EmployeeServiceImpl(private val employeeRepository: EmployeeRepository): EmployeeService {



    override fun createEmployee(employeeDto: EmployeeDto): EmployeeDto {
        val employee = mapToEmployee(employeeDto)
        val savedEmployee = employeeRepository.save<Employee>(employee)
        return mapToEmployeeDto(savedEmployee)
    }

    override fun getEmployeeById(employeeId: Long): EmployeeDto {
        val employee = employeeRepository.findById(employeeId)
            .orElseThrow<ResourceNotFoundException?>(Supplier { ResourceNotFoundException("Employee is not exists with given id : $employeeId") })

        return mapToEmployeeDto(employee)
    }

    override fun getAllEmployees(): MutableList<EmployeeDto> {
        val employees = employeeRepository.findAll()
        return employees.stream()
            .map<EmployeeDto> { employee: Employee -> mapToEmployeeDto(employee) }
            .collect(Collectors.toList())
    }

    override fun updateEmployee(
        employeeId: Long,
        updatedEmployee: EmployeeDto
    ): EmployeeDto {
        val employee = employeeRepository.findById(employeeId).orElseThrow<ResourceNotFoundException?>(
            Supplier { ResourceNotFoundException("Employee is not exists with given id: $employeeId") }
        ).copy(firstName = updatedEmployee.firstName, lastName = updatedEmployee.lastName, email = updatedEmployee.email)
        val updatedEmployeeObj = employeeRepository.save<Employee>(employee)
        return mapToEmployeeDto(updatedEmployeeObj)
    }

    override fun deleteEmployee(employeeId: Long) {
        employeeRepository.findById(employeeId).orElseThrow<ResourceNotFoundException?>(
            Supplier { ResourceNotFoundException("Employee is not exists with given id: $employeeId") }
        )

        employeeRepository.deleteById(employeeId)
    }
}