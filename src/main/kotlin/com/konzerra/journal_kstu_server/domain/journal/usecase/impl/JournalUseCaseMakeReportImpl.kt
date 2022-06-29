package com.konzerra.journal_kstu_server.domain.journal.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.JournalReport
import com.konzerra.journal_kstu_server.domain.journal.usecase.JournalUseCaseMakeReport

@UseCase
class JournalUseCaseMakeReportImpl(
    private val journalOutPortFindById: OutPortFindById<Journal,Long>
) : JournalUseCaseMakeReport {
    override fun execute(journalId: Long, lang:String): JournalReport {
        val journal = journalOutPortFindById.execute(journalId)
        val journalData = journal.dataByLanguage(lang)
        val journalReport = JournalReport(
            name = journalData.name + " " + journalData.version
        )

        journal.articles.filter {
            it.status == "" && it.reviewer!==null
        }.forEach {
            it.reviewer?.let {  reviewer->
                journalReport.addReviewer(
                    name = reviewer.appUser.name,
                    email = reviewer.appUser.email
                )
            }
        }
        return journalReport
    }
}