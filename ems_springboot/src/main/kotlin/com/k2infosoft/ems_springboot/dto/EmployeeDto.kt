package com.k2infosoft.ems_springboot.dto

data class EmployeeDto(
    val id: Long = 0,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = ""
)
