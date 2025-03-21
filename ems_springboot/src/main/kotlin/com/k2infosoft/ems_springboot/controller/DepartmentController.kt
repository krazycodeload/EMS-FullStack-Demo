package com.k2infosoft.ems_springboot.controller

import com.k2infosoft.ems_springboot.dto.DepartmentDto
import com.k2infosoft.ems_springboot.service.DepartmentService
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
@RequestMapping("/api/departments")
@Tag(name = "EMS API", description = "Sample API for Department")
class DepartmentController {

    lateinit var departmentService: DepartmentService

    @Autowired
    constructor(it: DepartmentService){
        departmentService = it
    }

    // Build Create or Add Department REST API
    @PostMapping
    @Operation(summary = "Department Creation Api", description = "Create A New Department")
    fun createDepartment(@RequestBody departmentDto: DepartmentDto): ResponseEntity<DepartmentDto> {
        val department = departmentService.createDepartment(departmentDto)
        return ResponseEntity<DepartmentDto>(department, HttpStatus.CREATED)
    }

    // Build Get Department REST API
    @GetMapping("{id}")
    @Operation(summary = "Get Department Details by Id", description = "Returns a Department details as per id")
    fun getDepartmentById(@PathVariable("id") departmentId: Long): ResponseEntity<DepartmentDto> {
        val departmentDto = departmentService.getDepartmentById(departmentId)
        return ResponseEntity.ok<DepartmentDto>(departmentDto)
    }

    // Build Get All Departments REST API
    @GetMapping
    @Operation(summary = "Get All Department Details", description = "Returns a list of Department stored in table")
    fun getAllDepartments(): ResponseEntity<MutableList<DepartmentDto>> {
        val departments: MutableList<DepartmentDto> = departmentService.getAllDepartments()
        return ResponseEntity.ok<MutableList<DepartmentDto>>(departments)
    }

    // Build Update Department REST API
    @PutMapping("{id}")
    @Operation(summary = "Update Department Details by Id", description = "Create Existing Department Details")
    fun updateDepartment(
        @PathVariable("id") departmentId: Long,
        @RequestBody updatedDepartment: DepartmentDto
    ): ResponseEntity<DepartmentDto?> {
        val departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment)
        return ResponseEntity.ok<DepartmentDto>(departmentDto)
    }

    // Build Delete Department REST API
    @DeleteMapping("{id}")
    @Operation(summary = "Delete Department Details by Id", description = "Delete Existing Department Details as per Id")
    fun deleteDepartment(@PathVariable("id") departmentId: Long): ResponseEntity<String> {
        departmentService.deleteDepartment(departmentId)
        return ResponseEntity.ok<String>("Department deleted successfully!.")
    }
}