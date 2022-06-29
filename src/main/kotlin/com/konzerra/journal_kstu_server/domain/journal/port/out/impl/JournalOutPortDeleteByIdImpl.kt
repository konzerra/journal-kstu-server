
package com.konzerra.journal_kstu_server.domain.journal.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.JournalRepository
    


@OutPort
class JournalOutPortDeleteByIdImpl(
private val repository: JournalRepository
) : OutPortDeleteById<Journal, Long> {
  override fun execute(id: Long) {
      repository.deleteById(id)
  }
}
  