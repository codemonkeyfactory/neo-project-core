package com.codemonkeyfactory.neo.core.email

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class EmailServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(EmailServiceApplication::class.java, *args)
}