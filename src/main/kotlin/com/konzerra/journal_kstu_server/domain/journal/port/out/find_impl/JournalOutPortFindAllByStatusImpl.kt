package com.konzerra.journal_kstu_server.domain.journal.port.out.find_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.JournalRepository
import com.konzerra.journal_kstu_server.domain.journal.port.out.JournalOutPortFindAllByStatus

@OutPort
class JournalOutPortFindAllByStatusImpl(
    private val repository: JournalRepository,
) : JournalOutPortFindAllByStatus {
    override fun execute(status: String): List<Journal> {
        return repository.findAllByStatusEquals(status)
    }
}