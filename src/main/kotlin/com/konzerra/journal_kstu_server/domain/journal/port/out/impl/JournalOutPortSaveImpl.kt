
package com.konzerra.journal_kstu_server.domain.journal.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.JournalRepository


@OutPort
class JournalOutPortSaveImpl(
    private val repository: JournalRepository,
): OutPortSave<Journal> {
    override fun execute(entity: Journal) {
        repository.save(entity)
    }
}
  