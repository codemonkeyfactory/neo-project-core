package com.codemonkeyfactory.neo.core.email.controller

import mu.KotlinLogging
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class EmailRestControllerBaseIntegrationTest {
    private val host = "http://localhost"
    @LocalServerPort
    private val port: Int = -1
    private val path = "/email"

    protected val restTemplate = RestTemplate()
    protected val endpoint: String
        get() = "$host:$port$path"
}