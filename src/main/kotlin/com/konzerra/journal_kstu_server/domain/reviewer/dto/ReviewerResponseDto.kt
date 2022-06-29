package com.konzerra.journal_kstu_server.domain.reviewer.dto

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryResponseDto
import com.konzerra.journal_kstu_server.domain.reviewer.Reviewer
import org.springframework.stereotype.Component


class ReviewerResponseDto(
    var id: Long? = null,
    var name: String,
    var email: String,
    var category: CategoryResponseDto
) : ResponseDtoI {

    @Component
    companion object:Mapper<Reviewer,ReviewerResponseDto>{
        override fun toResponseDto(entity: Reviewer, lang: String): ReviewerResponseDto {
            return ReviewerResponseDto(
                id= entity.id,
                name = entity.appUser.name,
                email =  entity.appUser.email,
                category = CategoryResponseDto.toResponseDto(entity.category,lang)
            )
        }

    }
}