package com.konzerra.journal_kstu_server.domain.article.port.`in`

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleSaveDto
import org.springframework.web.multipart.MultipartFile

interface ArticleInPortSave {
    fun execute(
        saveDto: ArticleSaveDto,
        file:MultipartFile
    ):Any
}