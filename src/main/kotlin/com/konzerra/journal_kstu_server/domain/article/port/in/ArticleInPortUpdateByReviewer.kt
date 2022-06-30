package com.konzerra.journal_kstu_server.domain.article.port.`in`

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateByReviewerDto
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateDtoByAdmin
import org.springframework.web.multipart.MultipartFile

interface ArticleInPortUpdateByReviewer {
    fun execute(
        updateDto:ArticleUpdateByReviewerDto,
        reviewerBlankFile:MultipartFile?,
    ):Any
}