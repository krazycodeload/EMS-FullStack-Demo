package com.k2infosoft.ems_springboot.service.impl

import com.k2infosoft.ems_springboot.dto.DepartmentDto
import com.k2infosoft.ems_springboot.entity.Department
import com.k2infosoft.ems_springboot.exception.ResourceNotFoundException
import com.k2infosoft.ems_springboot.mapper.DepartmentMapper.mapToDepartment
import com.k2infosoft.ems_springboot.mapper.DepartmentMapper.mapToDepartmentDto
import com.k2infosoft.ems_springboot.repository.DepartmentRepository
import com.k2infosoft.ems_springboot.service.DepartmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Supplier
import java.util.stream.Collectors


@Service
class DepartmentServiceImpl(private val departmentRepository: DepartmentRepository): DepartmentService {


    override fun createDepartment(departmentDto: DepartmentDto): DepartmentDto {
        val department = mapToDepartment(departmentDto)
        val savedDepartment = departmentRepository.save<Department>(department)
        return mapToDepartmentDto(savedDepartment)
    }

    override fun getDepartmentById(departmentId: Long): DepartmentDto {
        val department = departmentRepository.findById(departmentId).orElseThrow<ResourceNotFoundException?>(
            Supplier { ResourceNotFoundException("Department is not exists with a given id: $departmentId") }
        )
        return mapToDepartmentDto(department)
    }

    override fun getAllDepartments(): MutableList<DepartmentDto> {
        val departments = departmentRepository.findAll()
        return departments.stream()
            .map<DepartmentDto?> { department: Department? -> mapToDepartmentDto(department!!) }
            .collect(Collectors.toList())
    }

    override fun updateDepartment(
        departmentId: Long,
        updatedDepartment: DepartmentDto
    ): DepartmentDto {
        val department = departmentRepository.findById(departmentId).orElseThrow<ResourceNotFoundException?>(
            Supplier { ResourceNotFoundException("Department is not exists with a given id:" + departmentId) }
        ).copy(departmentName = updatedDepartment.departmentName, departmentDescription = updatedDepartment.departmentDescription)
        val savedDepartment = departmentRepository.save<Department?>(department)

        return mapToDepartmentDto(savedDepartment)
    }

    override fun deleteDepartment(departmentId: Long) {
        departmentRepository.findById(departmentId).orElseThrow<ResourceNotFoundException?>(
            Supplier { ResourceNotFoundException("Department is not exists with a given id: $departmentId") }
        )

        departmentRepository.deleteById(departmentId)
    }
}