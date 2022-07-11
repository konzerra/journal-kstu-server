package com.konzerra.journal_kstu_server.domain.journal.usecase

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleResponseDto
import org.springframework.data.domain.Page

interface JournalUseCaseFindAllArticlesPaginated {
    fun execute(journalId: Long, pageNumber: Int, pageSize: Int, lang: String): Page<ArticleResponseDto>
}