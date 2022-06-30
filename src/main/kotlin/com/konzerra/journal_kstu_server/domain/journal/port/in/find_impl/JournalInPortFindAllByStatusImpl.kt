package com.konzerra.journal_kstu_server.domain.journal.port.`in`.find_impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath
import com.konzerra.journal_kstu_server.domain.journal.port.`in`.JournalInPortFindAllByStatus
import com.konzerra.journal_kstu_server.domain.journal.usecase.JournalUseCaseFindAllByStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class JournalInPortFindAllByStatusImpl(
    private val useCaseFindAllByStatus: JournalUseCaseFindAllByStatus
) : JournalInPortFindAllByStatus {

    @GetMapping(JournalApiPath.findAllByStatus)
    override fun execute(
        @PathVariable status: String,
        @RequestHeader("Accept-Language") lang: String
    ): Any {
        return ResponseEntity(
            useCaseFindAllByStatus.execute(status,lang),
            HttpStatus.OK
        )
    }
}