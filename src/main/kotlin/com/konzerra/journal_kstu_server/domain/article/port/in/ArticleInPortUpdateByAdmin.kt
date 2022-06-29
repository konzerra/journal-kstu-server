package com.konzerra.journal_kstu_server.domain.article.port.`in`

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateDtoByAdmin
import org.springframework.web.multipart.MultipartFile

interface ArticleInPortUpdateByAdmin {
    fun execute(
        updateDto:ArticleUpdateDtoByAdmin,
        wordFile:MultipartFile?,
        pdfFile:MultipartFile?
    ):Any
}