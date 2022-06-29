
package com.konzerra.journal_kstu_server.domain.category.usecase.impl

import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.dto.CategorySaveDto
    
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseSaveAbstractImpl
import com.konzerra.journal_kstu_server.domain.category.Category

@UseCase
class CategoryUseCaseSaveImpl(
    override val outPortSave: OutPortSave<Category>
) : UseCaseSaveAbstractImpl<Category, CategorySaveDto>(){
    override fun execute(saveDto: CategorySaveDto) {
        outPortSave.execute(
            Category(
                dataList = saveDto.dataList
            )
        )
    }

}
    