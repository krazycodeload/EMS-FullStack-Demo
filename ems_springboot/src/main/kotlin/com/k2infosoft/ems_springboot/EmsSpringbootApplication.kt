package com.k2infosoft.ems_springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmsSpringbootApplication

fun main(args: Array<String>) {
	runApplication<EmsSpringbootApplication>(*args)
}
