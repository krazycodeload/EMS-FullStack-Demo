package com.k2infosoft.ems_springboot.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter



data class DepartmentDto(
    val id: Long = 0,
    val departmentName: String = "",
    val departmentDescription: String = ""
)
