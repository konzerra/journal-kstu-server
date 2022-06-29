package com.konzerra.journal_kstu_server.domain.journal.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath
import com.konzerra.journal_kstu_server.domain.journal.port.`in`.JournalInPortMakeReport
import com.konzerra.journal_kstu_server.domain.journal.usecase.JournalUseCaseMakeReport
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class JournalInPortMakeReportImpl(
    private val journalUseCaseMakeReport: JournalUseCaseMakeReport
) : JournalInPortMakeReport{

    @GetMapping(JournalApiPath.makeReport)
    override fun execute(@PathVariable id: Long, @RequestHeader("accept-language") lang: String): Any{
        return ResponseEntity(journalUseCaseMakeReport.execute(id,lang),HttpStatus.OK)
    }

}