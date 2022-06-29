package com.konzerra.journal_kstu_server.domain.journal.port.`in`.find_impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindAllPaginated
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class JournalInPortFindAllPaginatedImpl(
    private val useCaseFindAllPaginated: UseCaseFindAllPaginated<JournalResponseDto>
) : InPortFindAllPaginated{
    @GetMapping(JournalApiPath.findAllPaginated)
    override fun execute(
        @PathVariable pageNumber: Int,
        @RequestHeader("Accept-Language") lang:String
    ): Any {
        return ResponseEntity(
            useCaseFindAllPaginated.execute(pageNumber,10,lang),
            HttpStatus.OK
        )
    }
}