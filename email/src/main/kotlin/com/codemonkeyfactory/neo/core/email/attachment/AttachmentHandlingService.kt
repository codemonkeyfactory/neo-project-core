package com.codemonkeyfactory.neo.core.email.attachment

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import java.net.URI

/**
 * Handle attachments associated with the email.
 */
interface AttachmentHandlingService {
    /**
     * Save the received [multipart attachment][MultipartFile] and return its storage location as a URI.
     *
     * @param attachment The email attachment data
     * @return Location where the attachment was stored to.
     */
    fun save(attachment: MultipartFile): URI

    /**
     * Get the attachment from the provided [URI].
     *
     * @param attachmentUri URI in the attachment system for the attachment
     * @return Attachment represented as a Spring resource
     */
    fun get(attachmentUri: URI): Resource
}