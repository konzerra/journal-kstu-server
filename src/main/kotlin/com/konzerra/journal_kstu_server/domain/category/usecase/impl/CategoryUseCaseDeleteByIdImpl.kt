
package com.konzerra.journal_kstu_server.domain.category.usecase.impl

import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.category.Category

    

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseDeleteByIdAbstractImpl

@UseCase
class CategoryUseCaseDeleteByIdImpl(
    override val outPortDeleteById: OutPortDeleteById<Category, Long>
) : UseCaseDeleteByIdAbstractImpl<Category, Long>()
    