package com.konzerra.journal_kstu_server.domain.reviewer.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleResponseDto
import com.konzerra.journal_kstu_server.domain.reviewer.port.out.ReviewerOutPortFindByUserId
import com.konzerra.journal_kstu_server.domain.reviewer.usecase.ReviewerUseCaseFindArticles
import com.konzerra.journal_kstu_server.domain.user.AppUser

@UseCase
class ReviewerUseCaseFindArticlesImpl(
    private val reviewerOutPortFindByUserId: ReviewerOutPortFindByUserId
) : ReviewerUseCaseFindArticles {
    override fun execute(userId: Long, lang: String): List<ArticleResponseDto> {
        val articles = reviewerOutPortFindByUserId.execute(userId).articles
        return articles.toList().map {
            ArticleResponseDto.toResponseDto(it,lang)
        }
    }
}