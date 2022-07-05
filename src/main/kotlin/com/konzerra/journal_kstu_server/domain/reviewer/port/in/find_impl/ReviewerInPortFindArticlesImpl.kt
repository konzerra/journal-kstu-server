package com.konzerra.journal_kstu_server.domain.reviewer.port.`in`.find_impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerApiPath
import com.konzerra.journal_kstu_server.domain.reviewer.port.`in`.ReviewerInPortFindArticles
import com.konzerra.journal_kstu_server.domain.reviewer.usecase.ReviewerUseCaseFindArticles
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class ReviewerInPortFindArticlesImpl(
    private val reviewerUseCaseFindArticles: ReviewerUseCaseFindArticles,
) : ReviewerInPortFindArticles{

    @GetMapping(ReviewerApiPath.findArticles)
    override fun execute(
        @PathVariable id: Long,
        @RequestHeader("Accept-Language") lang: String):Any {
        return ResponseEntity(
            reviewerUseCaseFindArticles.execute(id,lang),
            HttpStatus.OK
        )
    }
}