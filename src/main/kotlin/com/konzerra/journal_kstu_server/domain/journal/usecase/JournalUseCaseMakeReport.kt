package com.konzerra.journal_kstu_server.domain.journal.usecase

import com.konzerra.journal_kstu_server.domain.journal.JournalReport

interface JournalUseCaseMakeReport {
    fun  execute(journalId: Long, lang : String):JournalReport

}