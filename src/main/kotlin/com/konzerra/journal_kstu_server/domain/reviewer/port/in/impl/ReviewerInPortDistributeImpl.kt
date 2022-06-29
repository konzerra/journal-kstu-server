package com.konzerra.journal_kstu_server.domain.reviewer.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerApiPath
import com.konzerra.journal_kstu_server.domain.reviewer.port.`in`.ReviewerInPortDistribute
import com.konzerra.journal_kstu_server.domain.reviewer.usecase.ReviewerUseCaseDistribute
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping


@InPort
class ReviewerInPortDistributeImpl (
    private val reviewerUseCaseDistribute: ReviewerUseCaseDistribute,
) : ReviewerInPortDistribute{

    @GetMapping(ReviewerApiPath.distribute)
    override fun execute(journalId: Long): Any {
     return ResponseEntity<String>(reviewerUseCaseDistribute.execute(journalId),HttpStatus.OK)
    }

}