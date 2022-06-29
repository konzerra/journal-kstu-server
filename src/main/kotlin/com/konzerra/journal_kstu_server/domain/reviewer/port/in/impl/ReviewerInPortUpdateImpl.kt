package com.konzerra.journal_kstu_server.domain.reviewer.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortUpdate
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerApiPath
import com.konzerra.journal_kstu_server.domain.reviewer.dto.ReviewerUpdateDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping

@InPort
class ReviewerInPortUpdateImpl(
    private val reviewerUseCaseUpdate: UseCaseUpdate<ReviewerUpdateDto>
) : InPortUpdate<ReviewerUpdateDto>{

    @PutMapping(ReviewerApiPath.update)
    override fun execute(updateDto: ReviewerUpdateDto): Any {
        reviewerUseCaseUpdate.execute(updateDto)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}