package com.codemonkeyfactory.neo.core.email.controller

import com.codemonkeyfactory.neo.core.email.attachment.AttachmentHandlingService
import com.codemonkeyfactory.neo.core.email.record.EmailRecordService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

private val LOGGER = KotlinLogging.logger {}

@RestController
@RequestMapping("/email")
class EmailRestController(
        val emailRecordService: EmailRecordService,
        val attachmentHandlingService: AttachmentHandlingService
) {

    @PostMapping
    fun send(
            @RequestParam to: String,
            @RequestParam subject: String,
            @RequestParam body: String,
            @RequestParam attachments: List<MultipartFile>
    ) {
        LOGGER.info("to: $to, subject: $subject, body: $body")
    }
}