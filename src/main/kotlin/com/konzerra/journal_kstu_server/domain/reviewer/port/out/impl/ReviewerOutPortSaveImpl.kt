package com.konzerra.journal_kstu_server.domain.reviewer.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerRepository

@OutPort
class ReviewerOutPortSaveImpl(
    private val repository: ReviewerRepository,
) : OutPortSave<Reviewer>{
    override fun execute(entity: Reviewer) {
         repository.save(entity)
    }

}