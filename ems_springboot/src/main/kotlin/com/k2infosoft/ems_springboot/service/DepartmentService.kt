package com.k2infosoft.ems_springboot.service

import com.k2infosoft.ems_springboot.dto.DepartmentDto



interface DepartmentService {

    fun createDepartment(departmentDto: DepartmentDto): DepartmentDto

    fun getDepartmentById(departmentId: Long): DepartmentDto

    fun getAllDepartments(): MutableList<DepartmentDto>

    fun updateDepartment(departmentId: Long, updatedDepartment: DepartmentDto): DepartmentDto

    fun deleteDepartment(departmentId: Long)
}