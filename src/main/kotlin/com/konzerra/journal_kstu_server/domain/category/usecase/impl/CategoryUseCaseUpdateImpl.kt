
package com.konzerra.journal_kstu_server.domain.category.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryUpdateDto
import com.konzerra.journal_kstu_server.annotation.UseCase

import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseUpdateAbstractImpl
import com.konzerra.journal_kstu_server.domain.category.Category

@UseCase
class CategoryUseCaseUpdateImpl(
    override val outPortSave: OutPortSave<Category>,
    override val outPortFindById: OutPortFindById<Category, Long>,
) : UseCaseUpdateAbstractImpl<Category, Long, CategoryUpdateDto>(){
    override fun execute(updateDto: CategoryUpdateDto) {
        val category = outPortFindById.execute(updateDto.id)
        category.dataList = updateDto.dataList
        outPortSave.execute(category)
    }
}
    