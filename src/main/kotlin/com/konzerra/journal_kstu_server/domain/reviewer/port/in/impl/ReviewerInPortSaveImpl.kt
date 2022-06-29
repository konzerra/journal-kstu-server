package com.konzerra.journal_kstu_server.domain.reviewer.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortSave
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.reviewer.ReviewerApiPath
import com.konzerra.journal_kstu_server.domain.reviewer.dto.ReviewerSaveDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@InPort
class ReviewerInPortSaveImpl(
    private val reviewerUseCaseSave: UseCaseSave<ReviewerSaveDto>
) : InPortSave<ReviewerSaveDto>{

    @PostMapping(ReviewerApiPath.save)
    override fun execute(@RequestBody saveDto: ReviewerSaveDto): Any {
        reviewerUseCaseSave.execute(saveDto)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }
}