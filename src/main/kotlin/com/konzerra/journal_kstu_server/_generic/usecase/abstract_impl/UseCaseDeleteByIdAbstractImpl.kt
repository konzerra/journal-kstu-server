package com.konzerra.journal_kstu_server._generic.usecase.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseDeleteById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById

abstract class UseCaseDeleteByIdAbstractImpl<Entity: EntityI, Id:Any>
    : UseCaseDeleteById<Entity, Id>
{
    protected abstract val outPortDeleteById: OutPortDeleteById<Entity, Id>
    override fun execute(id: Id) {
        outPortDeleteById.execute(id)
    }
}
