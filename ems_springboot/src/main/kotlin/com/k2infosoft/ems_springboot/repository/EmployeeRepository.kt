package com.k2infosoft.ems_springboot.repository

import com.k2infosoft.ems_springboot.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository


interface EmployeeRepository : JpaRepository<Employee, Long>