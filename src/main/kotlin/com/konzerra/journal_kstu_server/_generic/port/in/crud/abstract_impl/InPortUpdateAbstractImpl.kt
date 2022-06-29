package com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortUpdate
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate


abstract class InPortUpdateAbstractImpl<Entity: EntityI, Id:Any, UpdateDto: UpdateDtoI>
    : InPortUpdate<UpdateDto>
{
    protected abstract val useCaseUpdate: UseCaseUpdate<UpdateDto>
}