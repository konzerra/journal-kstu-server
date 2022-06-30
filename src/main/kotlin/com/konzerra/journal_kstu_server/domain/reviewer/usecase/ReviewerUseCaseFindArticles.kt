package com.konzerra.journal_kstu_server.domain.reviewer.usecase

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleResponseDto

interface ReviewerUseCaseFindArticles {
    fun execute(reviewerId:Long, lang:String):List<ArticleResponseDto>
}