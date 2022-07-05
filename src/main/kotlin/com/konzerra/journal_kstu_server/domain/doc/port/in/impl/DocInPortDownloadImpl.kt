package com.konzerra.journal_kstu_server.domain.doc.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.doc.DocApiPath
import com.konzerra.journal_kstu_server.domain.doc.port.`in`.DocInPortDownload
import com.konzerra.journal_kstu_server.domain.doc.usecase.DocUseCaseDownload
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.ContentDisposition
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@InPort
class DocInPortDownloadImpl(
    private val docUseCaseDownload: DocUseCaseDownload
) : DocInPortDownload{

    @GetMapping(DocApiPath.download)
    override fun execute(@PathVariable id: Long): Any {
        val doc = docUseCaseDownload.execute(id)

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(doc.mimeType))
            .header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+doc.name+"\"")
            .body(ByteArrayResource(doc.content))
    }
}