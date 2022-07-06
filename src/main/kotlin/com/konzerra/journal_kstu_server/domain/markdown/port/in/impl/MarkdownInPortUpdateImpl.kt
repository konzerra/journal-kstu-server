package com.konzerra.journal_kstu_server.domain.markdown.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortUpdate
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownApi
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownUpdateDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping

@InPort
class MarkdownInPortUpdateImpl(
    private val markdownUseCaseUpdate: UseCaseUpdate<MarkdownUpdateDto>
) : InPortUpdate<MarkdownUpdateDto>{

    @PutMapping(MarkdownApi.update)
    override fun execute(updateDto: MarkdownUpdateDto): Any {
        markdownUseCaseUpdate.execute(updateDto)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}