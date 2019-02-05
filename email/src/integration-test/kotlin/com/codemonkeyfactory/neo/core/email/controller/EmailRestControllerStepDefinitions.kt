package com.codemonkeyfactory.neo.core.email.controller

import cucumber.api.java8.En
import mu.KotlinLogging
import org.junit.Ignore

private val LOGGER = KotlinLogging.logger {}

@Ignore
class EmailRestControllerStepDefinitions: EmailRestControllerBaseIntegrationTest(), En {
    init {
        When("^I call (\\w+) on /email$") {
            httpMethod: String ->
        }

        And("^(\\w+) param is (\\w)$") {

        }
    }
}