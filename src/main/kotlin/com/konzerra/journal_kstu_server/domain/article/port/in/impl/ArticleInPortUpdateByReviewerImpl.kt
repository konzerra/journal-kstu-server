package com.konzerra.journal_kstu_server.domain.article.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.article.ArticleApiPath
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateByReviewerDto
import com.konzerra.journal_kstu_server.domain.article.dto.ArticleUpdateDtoByAdmin
import com.konzerra.journal_kstu_server.domain.article.port.`in`.ArticleInPortUpdateByAdmin
import com.konzerra.journal_kstu_server.domain.article.port.`in`.ArticleInPortUpdateByReviewer
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseUpdateByAdmin
import com.konzerra.journal_kstu_server.domain.article.usecase.ArticleUseCaseUpdateByReviewer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@InPort
class ArticleInPortUpdateByReviewerImpl(
    private val useCaseUpdate: ArticleUseCaseUpdateByReviewer
) : ArticleInPortUpdateByReviewer {
    @PutMapping(ArticleApiPath.updatePathByReviewer)
    override fun execute(
        @RequestPart updateDto: ArticleUpdateByReviewerDto,
        @RequestPart(required = false) reviewerBlankFile: MultipartFile?,
        ):Any {
        useCaseUpdate.execute(updateDto, reviewerBlankFile)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}