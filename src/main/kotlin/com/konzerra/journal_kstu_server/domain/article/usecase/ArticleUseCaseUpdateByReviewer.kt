package com.konzerra.journal_kstu_server.domain.article.usecase

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateByReviewerDto
import org.springframework.web.multipart.MultipartFile

interface ArticleUseCaseUpdateByReviewer {
    fun execute(
        updateDto: ArticleUpdateByReviewerDto,
        reviewerBlankFile: MultipartFile?
    )
}