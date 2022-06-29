package com.konzerra.journal_kstu_server.domain.reviewer.port.out.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@OutPort
class ReviewerOutPortFindAllPaginatedImpl(
    private val repository: ReviewerRepository
) : OutPortFindAllPaginated<Reviewer>{
    override fun execute(pageNumber: Int, pageSize: Int): Page<Reviewer> {
        val pageable = PageRequest.of(pageNumber,pageSize, Sort.unsorted())
        return repository.findAll(pageable)
    }
}