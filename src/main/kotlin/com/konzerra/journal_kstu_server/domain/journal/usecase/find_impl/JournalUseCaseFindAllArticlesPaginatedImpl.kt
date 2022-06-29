package com.konzerra.journal_kstu_server.domain.journal.usecase.find_impl

import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleResponseDto
import com.konzerra.journal_kstu_server.domain.journal.port.out.JournalOutPortFindAllArticlesPaginated
import com.konzerra.journal_kstu_server.domain.journal.usecase.JournalUseCaseFindAllArticlesPaginated
import org.springframework.data.domain.Page

@UseCase
class JournalUseCaseFindAllArticlesPaginatedImpl(
    private val journalOutPortFindAllArticlesPaginated: JournalOutPortFindAllArticlesPaginated
) : JournalUseCaseFindAllArticlesPaginated {
    override fun execute(journalId: Long,pageNumber: Int, pageSize: Int): Page<ArticleResponseDto> {
        return journalOutPortFindAllArticlesPaginated.execute(
            journalId,
            pageNumber,
            pageSize
        ).map {
            ArticleResponseDto.toResponseDto(it,"Ru")
        }
    }
}