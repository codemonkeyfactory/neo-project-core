package com.codemonkeyfactory.neo.core.email.record

import java.net.URI
import java.time.Instant
import java.util.UUID

data class EmailRecord(
        val id: UUID,
        val time: Instant,
        val to: List<String>,
        val cc: List<String>,
        val bcc: List<String>,
        val body: String,
        val attachments: List<URI>
)