package com.konzerra.journal_kstu_server.domain.markdown.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindAllPaginated
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownApi
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class MarkdownInPortFindAllPaginated(
    private val markdownUseCaseFindAllPaginated: UseCaseFindAllPaginated<MarkdownResponseDto>
):InPortFindAllPaginated {

    @GetMapping(MarkdownApi.findAllPaginated)
    override fun execute(
        @PathVariable pageNumber: Int,
        @PathVariable pageSize: Int,
        @RequestHeader lang: String
    ): Any {
        return ResponseEntity(
            markdownUseCaseFindAllPaginated.execute(pageNumber,pageSize, lang),
            HttpStatus.OK
        )
    }


}