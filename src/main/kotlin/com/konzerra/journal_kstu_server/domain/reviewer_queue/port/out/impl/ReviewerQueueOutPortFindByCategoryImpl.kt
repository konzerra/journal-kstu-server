package com.konzerra.journal_kstu_server.domain.reviewer_queue.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.reviewer_queue.ReviewerQueue
import com.konzerra.journal_kstu_server.domain.reviewer_queue.ReviewerQueueRepository
import com.konzerra.journal_kstu_server.domain.reviewer_queue.port.out.ReviewerQueueOutPortFindByCategory

@OutPort
class ReviewerQueueOutPortFindByCategoryImpl(
    private val repository: ReviewerQueueRepository,
    private val categoryOutPortFindById:OutPortFindById<Category,Long>
) : ReviewerQueueOutPortFindByCategory {
    override fun execute(categoryId: Long): ReviewerQueue {
        var reviewerQueue = repository.findByCategoryIdIs(categoryId)
        if (reviewerQueue == null){
            reviewerQueue = ReviewerQueue(
                category = categoryOutPortFindById.execute(categoryId),
            )
            reviewerQueue = repository.save(reviewerQueue)

        }
        return reviewerQueue
    }
}