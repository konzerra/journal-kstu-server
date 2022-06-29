package com.konzerra.journal_kstu_server.domain.journal.port.out.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.JournalRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@OutPort
class JournalOutPortFindAllPaginatedImpl(
    private val repository: JournalRepository
) : OutPortFindAllPaginated<Journal> {
    override fun execute(pageNumber: Int, pageSize: Int): Page<Journal> {
        val pageable = PageRequest.of(pageNumber,pageSize, Sort.unsorted())
        return repository.findAll(pageable)
    }
}