
package com.konzerra.journal_kstu_server.domain.category.usecase.find_impl

import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryResponseDto
    
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper

@UseCase
class CategoryUseCaseFindByIdImpl(
    override val outPortFindById: OutPortFindById<Category, Long>,
    override val mapper: Mapper<Category, CategoryResponseDto>
) : UseCaseFindByIdAbstractImpl<Category, Long, CategoryResponseDto>()
    