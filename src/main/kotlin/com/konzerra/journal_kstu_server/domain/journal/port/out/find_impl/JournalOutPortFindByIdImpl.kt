
package com.konzerra.journal_kstu_server.domain.journal.port.out.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.JournalRepository
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException


@OutPort
class JournalOutPortFindByIdImpl(
    private val repository: JournalRepository
): OutPortFindById<Journal, Long> {
    override fun execute(id: Long): Journal {
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException(
                className = Journal::class.simpleName ?: "className",
                fieldName = Journal::id.name,
                fieldValue = id
            )
        }


    }
}
  