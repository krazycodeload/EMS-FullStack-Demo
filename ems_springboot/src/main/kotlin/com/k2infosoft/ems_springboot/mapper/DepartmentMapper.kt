package com.k2infosoft.ems_springboot.mapper

import com.k2infosoft.ems_springboot.dto.DepartmentDto
import com.k2infosoft.ems_springboot.entity.Department


object DepartmentMapper {
    // convert department jpa entity into department dto
    fun mapToDepartmentDto(department: Department): DepartmentDto {
        return DepartmentDto(
            department.id,
            department.departmentName,
            department.departmentDescription
        )
    }

    // convert department dto into department jpa entity
    fun mapToDepartment(departmentDto: DepartmentDto): Department {
        return Department(
            departmentDto.id,
            departmentDto.departmentName,
            departmentDto.departmentDescription
        )
    }
}