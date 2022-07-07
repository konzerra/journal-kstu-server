package com.konzerra.journal_kstu_server.domain.markdown.port.`in`.find_impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownApi
import com.konzerra.journal_kstu_server.domain.markdown.port.`in`.MarkdownInPortFindByName
import com.konzerra.journal_kstu_server.domain.markdown.usecase.MarkdownUseCaseFindByName
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class MarkdownInPortFindByNameImpl(
    private val markdownUseCaseFindByName: MarkdownUseCaseFindByName
) : MarkdownInPortFindByName{
    @GetMapping(MarkdownApi.findByName)
    override fun execute(
        @PathVariable name: String,
        @RequestHeader lang: String
    ): Any {
        return ResponseEntity(
            markdownUseCaseFindByName.execute(name,lang),
            HttpStatus.OK
        )
    }
}