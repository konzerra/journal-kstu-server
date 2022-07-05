package com.konzerra.journal_kstu_server.domain.reviewer

import com.konzerra.journal_kstu_server.domain.user.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewerRepository : JpaRepository<Reviewer,Long>{
    fun findReviewersByActiveIsTrueAndCategoryIdIs(category_id: Long):List<Reviewer>
    fun findReviewerByAppUserIdIs(appUser_id: Long):Reviewer?
}