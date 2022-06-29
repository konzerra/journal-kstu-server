package com.konzerra.journal_kstu_server.domain.category.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindAllPaginatedAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryResponseDto


@UseCase
class CategoryUseCaseFindAllPaginated(
    override val outPortFindAllPaginated: OutPortFindAllPaginated<Category>,
    override val mapper: Mapper<Category, CategoryResponseDto>
) : UseCaseFindAllPaginatedAbstractImpl<Category,CategoryResponseDto>(){

}