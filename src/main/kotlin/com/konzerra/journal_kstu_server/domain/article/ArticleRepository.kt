package com.konzerra.journal_kstu_server.domain.article

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface ArticleRepository:JpaRepository<Article,Long>{
    fun findArticlesByJournalIdIs(journal_id: Long, pageable: Pageable):Page<Article>
}