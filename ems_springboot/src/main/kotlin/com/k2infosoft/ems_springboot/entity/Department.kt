package com.k2infosoft.ems_springboot.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val  id: Long = 0,
    var departmentName: String = "",
    var departmentDescription: String = "",
)
