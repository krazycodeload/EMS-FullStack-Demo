package com.k2infosoft.ems_springboot.controller

import com.k2infosoft.ems_springboot.dto.EmployeeDto
import com.k2infosoft.ems_springboot.service.EmployeeService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
@Tag(name = "EMS API", description = "Sample API for Employee")
class EmployeeController {

 lateinit var employeeService: EmployeeService

    @Autowired
    constructor(it: EmployeeService){
        employeeService = it
    }

    // Build Add Employee REST API
    @PostMapping
    @Operation(summary = "Employee Creation Api", description = "Create A New Employee")
    fun createEmployee(@RequestBody employeeDto: EmployeeDto): ResponseEntity<EmployeeDto> {
        val savedEmployee = employeeService.createEmployee(employeeDto)
        return ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED)
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    @Operation(summary = "Get Employees Details by Id", description = "Returns a Employee details as per id")
    fun getEmployeeById(@PathVariable("id") employeeId: Long): ResponseEntity<EmployeeDto> {
        val employeeDto = employeeService.getEmployeeById(employeeId)
        return ResponseEntity.ok<EmployeeDto>(employeeDto)
    }

    // Build Get All Employees REST API
    @GetMapping
    @Operation(summary = "Get All Employees Details", description = "Returns a list of Employee stored in table")
    fun getAllEmployees(): ResponseEntity<MutableList<EmployeeDto>> {
        val employees: MutableList<EmployeeDto> = employeeService.getAllEmployees()
        return ResponseEntity.ok<MutableList<EmployeeDto>>(employees)
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    @Operation(summary = "Update Employees Details by Id", description = "Create Existing Employee Details")
    fun updateEmployee(
        @PathVariable("id") employeeId: Long,
        @RequestBody updatedEmployee: EmployeeDto
    ): ResponseEntity<EmployeeDto?> {
        val employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee)
        return ResponseEntity.ok<EmployeeDto>(employeeDto)
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    @Operation(summary = "Delete Employees Details by Id", description = "Delete Existing Employee Details as per Id")
    fun deleteEmployee(@PathVariable("id") employeeId: Long): ResponseEntity<String> {
        employeeService.deleteEmployee(employeeId)
        return ResponseEntity.ok<String>("Employee deleted successfully!.")
    }
}