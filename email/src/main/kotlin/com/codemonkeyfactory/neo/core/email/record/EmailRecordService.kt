package com.codemonkeyfactory.neo.core.email.record

import java.util.UUID

interface EmailRecordService {
    fun save(emailRecord: EmailRecord): UUID

    fun get(id: UUID): EmailRecord
}