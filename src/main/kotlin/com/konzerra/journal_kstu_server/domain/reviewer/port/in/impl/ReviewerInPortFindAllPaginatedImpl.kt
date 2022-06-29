package com.konzerra.journal_kstu_server.domain.reviewer.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindAllPaginated
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerApiPath
import com.konzerra.journal_kstu_server.domain.reviewer.dto.ReviewerResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class ReviewerInPortFindAllPaginatedImpl(
    private val reviewerUseCaseFindAllPaginated: UseCaseFindAllPaginated<ReviewerResponseDto>
) : InPortFindAllPaginated{

    @GetMapping(ReviewerApiPath.findAllPaginated)
    override fun execute(
        @PathVariable pageNumber: Int,
        @RequestHeader("Accept-Language") lang: String
    ): Any {

        return ResponseEntity(
            reviewerUseCaseFindAllPaginated.execute(pageNumber, 10,lang),
            HttpStatus.OK
        )
    }
}