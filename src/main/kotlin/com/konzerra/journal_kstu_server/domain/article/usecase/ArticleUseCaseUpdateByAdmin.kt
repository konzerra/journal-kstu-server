package com.konzerra.journal_kstu_server.domain.article.usecase

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateDtoByAdmin
import org.springframework.web.multipart.MultipartFile

interface ArticleUseCaseUpdateByAdmin {
    fun execute(
        updateDto: ArticleUpdateDtoByAdmin,
        wordFile: MultipartFile?,
        pdfFile: MultipartFile?
    )
}