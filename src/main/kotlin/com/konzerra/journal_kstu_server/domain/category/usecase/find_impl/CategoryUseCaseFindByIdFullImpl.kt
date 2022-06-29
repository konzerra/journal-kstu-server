package com.konzerra.journal_kstu_server.domain.category.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryFullResponseDto

@UseCase
class CategoryUseCaseFindByIdFullImpl(
    private val outPortFindById:OutPortFindById<Category,Long>,
    private val mapper: Mapper<Category,CategoryFullResponseDto>
) : UseCaseFindByIdFull<CategoryFullResponseDto, Long> {
    override fun execute(id: Long): CategoryFullResponseDto {
        return mapper.toResponseDto(outPortFindById.execute(id))
    }
}