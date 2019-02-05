package com.codemonkeyfactory.neo.core.email.controller

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/integration-test/resources/features/email-rest-controller.feature"],
        plugin = ["pretty", "html:target/cucumber"]
)
class EmailRestControllerIntegrationTest