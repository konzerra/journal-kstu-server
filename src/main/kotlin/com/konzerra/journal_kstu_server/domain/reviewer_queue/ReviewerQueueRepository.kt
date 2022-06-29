package com.konzerra.journal_kstu_server.domain.reviewer_queue

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewerQueueRepository : JpaRepository<ReviewerQueue,Long> {

    fun findByCategoryIdIs(category_id: Long):ReviewerQueue?
}