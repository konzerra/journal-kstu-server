
package com.konzerra.journal_kstu_server.domain.category.usecase.find_impl

import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryResponseDto
    
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAll
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindAllAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper

@UseCase
class CategoryUseCaseFindAllImpl(
    override val outPortFindAll: OutPortFindAll<Category>,
    override val mapper: Mapper<Category, CategoryResponseDto>
) : UseCaseFindAllAbstractImpl<Category, CategoryResponseDto>()
    