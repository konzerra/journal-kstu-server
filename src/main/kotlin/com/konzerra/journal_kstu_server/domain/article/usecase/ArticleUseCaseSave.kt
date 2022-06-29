package com.konzerra.journal_kstu_server.domain.article.usecase

import com.konzerra.journal_kstu_server.domain.article.dto.ArticleSaveDto
import org.springframework.web.multipart.MultipartFile

interface ArticleUseCaseSave {
    fun execute(saveDto:ArticleSaveDto,file:MultipartFile)
}