package com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindById


abstract class InPortFindByIdAbstractImpl<Entity: EntityI,Id:Any,ResponseDto: ResponseDtoI>
    : InPortFindById<Id>
{
    protected abstract val useCaseFindById: UseCaseFindById<Entity, Id, ResponseDto>
}