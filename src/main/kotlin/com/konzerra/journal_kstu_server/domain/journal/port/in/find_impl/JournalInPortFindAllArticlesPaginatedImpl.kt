package com.konzerra.journal_kstu_server.domain.journal.port.`in`.find_impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath
import com.konzerra.journal_kstu_server.domain.journal.port.`in`.JournalInPortFindAllArticlesPaginated
import com.konzerra.journal_kstu_server.domain.journal.usecase.JournalUseCaseFindAllArticlesPaginated
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class JournalInPortFindAllArticlesPaginatedImpl(
    private val journalUseCaseFindAllArticlesPaginated: JournalUseCaseFindAllArticlesPaginated
) : JournalInPortFindAllArticlesPaginated{
    @GetMapping(JournalApiPath.findAllArticlesPaginated)
    override fun execute(
        @PathVariable id: Long,
        @PathVariable pageNumber: Int,
        @PathVariable pageSize: Int,
        @RequestHeader("Accept-Language") lang: String
    ): Any {
        return ResponseEntity(journalUseCaseFindAllArticlesPaginated.execute(
            id,
            pageNumber,
            pageSize,
            lang
        ),
            HttpStatus.OK
        )
    }

}