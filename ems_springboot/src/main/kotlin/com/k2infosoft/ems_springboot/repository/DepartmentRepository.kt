package com.k2infosoft.ems_springboot.repository

import com.k2infosoft.ems_springboot.entity.Department
import org.springframework.data.jpa.repository.JpaRepository


interface DepartmentRepository : JpaRepository<Department, Long>