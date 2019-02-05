package com.codemonkeyfactory.neo.core.email.attachment

import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.net.URI

/**
 * Implementation of [AttachmentHandlingService] using local file storage.
 */
@Service
class AttachmentHandlingServiceLocalStorageImpl : AttachmentHandlingService {
    override fun save(attachment: MultipartFile): URI {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(attachmentUri: URI): Resource {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}