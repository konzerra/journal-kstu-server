package com.konzerra.journal_kstu_server.domain.reviewer_queue.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.reviewer_queue.ReviewerQueue
import com.konzerra.journal_kstu_server.domain.reviewer_queue.ReviewerQueueRepository

@OutPort
class ReviewerQueueOutPortSaveImpl(
    private val repository: ReviewerQueueRepository
) : OutPortSave<ReviewerQueue>{
    override fun execute(entity: ReviewerQueue) {
        repository.save(entity)
    }
}