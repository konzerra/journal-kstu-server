package com.konzerra.journal_kstu_server.domain.reviewer.port.out.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerRepository
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException

@OutPort
class ReviewerOutPortFindByIdImpl(
    private val repository: ReviewerRepository
) : OutPortFindById<Reviewer, Long>{
    override fun execute(id: Long): Reviewer {
        return repository.findById(id).orElseThrow{
            ResourceNotFoundException(
                className = "Reviewer",
                fieldName = "id",
                fieldValue = id
            )
        }
    }
}