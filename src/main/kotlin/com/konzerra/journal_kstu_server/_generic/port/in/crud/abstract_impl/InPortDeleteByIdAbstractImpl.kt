package com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortDeleteById
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseDeleteById


abstract class InPortDeleteByIdAbstractImpl<Entity: EntityI, Id:Any>
    : InPortDeleteById<Entity, Id> {
    protected abstract val useCaseDeleteById: UseCaseDeleteById<Entity, Id>
}