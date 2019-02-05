package com.codemonkeyfactory.neo.core.email.record

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EmailRecordServiceLocalStorageImpl : EmailRecordService {
    override fun save(emailRecord: EmailRecord): UUID {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: UUID): EmailRecord {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}