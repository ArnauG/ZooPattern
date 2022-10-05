package com.example.zoo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	scanBasePackages = [
		"com.example.zoo.infrastructure.configuration",
		"com.example.zoo.infrastructure.controller"
	]
)
class ZooApplication

fun main(args: Array<String>) {
	runApplication<ZooApplication>(*args)
}
