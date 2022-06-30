package com.konzerra.journal_kstu_server.domain.reviewer.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleResponseDto
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.usecase.ReviewerUseCaseFindArticles

@UseCase
class ReviewerUseCaseFindArticlesImpl(
    private val reviewerOutPortFindById: OutPortFindById<Reviewer,Long>,
) : ReviewerUseCaseFindArticles {
    override fun execute(reviewerId: Long, lang: String): List<ArticleResponseDto> {
        val articles = reviewerOutPortFindById.execute(reviewerId).articles
        return articles.toList().map {
            ArticleResponseDto.toResponseDto(it,lang)
        }
    }
}