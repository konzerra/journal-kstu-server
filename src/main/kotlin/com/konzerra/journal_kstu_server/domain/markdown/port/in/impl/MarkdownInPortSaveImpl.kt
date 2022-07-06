package com.konzerra.journal_kstu_server.domain.markdown.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortSave
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownApi
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownSaveDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@InPort
class MarkdownInPortSaveImpl(
   private val markdownUseCaseSave: UseCaseSave<MarkdownSaveDto>
) : InPortSave<MarkdownSaveDto>{

    @PostMapping(MarkdownApi.save)
    override fun execute(@RequestBody saveDto: MarkdownSaveDto): Any {
        markdownUseCaseSave.execute(saveDto)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

}