package com.konzerra.journal_kstu_server._generic.usecase.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.UpdateDtoI
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate

abstract class UseCaseUpdateAbstractImpl<Entity: EntityI, Id:Any, UpdateDto: UpdateDtoI>
    : UseCaseUpdate<UpdateDto> {
    protected abstract val outPortSave: OutPortSave<Entity>
    protected abstract val outPortFindById: OutPortFindById<Entity,Id>
}