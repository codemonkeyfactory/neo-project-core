package com.codemonkeyfactory.neo.core.email.controller

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockKExtension::class)
class EmailRestControllerTest {

    private val emailRestController = EmailRestController()

    private val mvc = MockMvcBuilders.standaloneSetup(emailRestController)
            .build()

    @Test
    fun `test send success`() {
        mvc.perform(
                post("/email")
                        .param("to", "test@example.com")
                        .param("subject", "test subject")
                        .param("body", "test body"))
                .andExpect(status().isOk)
    }

    @Nested
    inner class ErrorCases {
        @Test
        fun `test send missing to param`() {
            mvc.perform(
                    post("/email")
                            .param("subject", "test subject")
                            .param("body", "test body"))
                    .andExpect(status().isBadRequest)
        }
    }
}