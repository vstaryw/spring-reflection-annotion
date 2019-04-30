package com.vstaryw.code

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ApplicationCode

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationCode::class.java, *args)
}