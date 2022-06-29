package com.konzerra.journal_kstu_server.domain.article.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.article.ArticleApiPath
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateDtoByAdmin
import com.konzerra.journal_kstu_server.domain.article.port.`in`.ArticleInPortUpdateByAdmin
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseUpdateByAdmin
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@InPort
class ArticleInPortUpdateByAdminImpl(
    private val useCaseUpdate: ArticleUseCaseUpdateByAdmin
) : ArticleInPortUpdateByAdmin{
    @PostMapping(ArticleApiPath.updatePathByAdmin)
    override fun execute(
        @RequestPart updateDto: ArticleUpdateDtoByAdmin,
        @RequestPart(required = false) wordFile: MultipartFile?,
        @RequestPart(required = false) pdfFile: MultipartFile?
    ):Any {
        useCaseUpdate.execute(updateDto, wordFile, pdfFile)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

}