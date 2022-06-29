package com.konzerra.journal_kstu_server.domain.reviewer.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import com.konzerra.journal_kstu_server.domain.reviewer.dto.ReviewerUpdateDto

@UseCase
class ReviewerUseCaseUpdateImpl(
    private val reviewerOutPortSave: OutPortSave<Reviewer>,
    private val reviewerOutPortFindById: OutPortFindById<Reviewer,Long>,
    private val categoryOutPortFindById: OutPortFindById<Category, Long>
): UseCaseUpdate<ReviewerUpdateDto> {

    override fun execute(updateDto: ReviewerUpdateDto) {
        val reviewer = reviewerOutPortFindById.execute(updateDto.id)

        reviewer.active=updateDto.active
        reviewer.category.id?.let { categoryId->
            if(categoryId != updateDto.categoryId){
                reviewer.category = categoryOutPortFindById.execute(updateDto.categoryId)
            }
        }
        reviewerOutPortSave.execute(reviewer)
    }
}