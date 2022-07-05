package com.konzerra.journal_kstu_server.domain.reviewer.port.out.find_impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerRepository
import com.konzerra.journal_kstu_server.domain.reviewer.port.out.ReviewerOutPortFindByUserId


@OutPort
class ReviewerOutPortFindByUserIdImpl (
    private val repository: ReviewerRepository
): ReviewerOutPortFindByUserId {
    override fun execute(userId: Long): Reviewer {
        return repository.findReviewerByAppUserIdIs(userId) ?: throw RuntimeException()
    }
}