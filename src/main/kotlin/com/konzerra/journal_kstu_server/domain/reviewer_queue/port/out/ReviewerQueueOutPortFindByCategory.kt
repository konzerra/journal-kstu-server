package com.konzerra.journal_kstu_server.domain.reviewer_queue.port.out

import com.konzerra.journal_kstu_server.domain.reviewer_queue.ReviewerQueue

interface ReviewerQueueOutPortFindByCategory {
    fun execute(categoryId:Long):ReviewerQueue
}