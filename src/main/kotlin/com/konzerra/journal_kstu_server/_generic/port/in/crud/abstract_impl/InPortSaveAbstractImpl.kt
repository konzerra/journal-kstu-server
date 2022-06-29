package com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.SaveDtoI
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortSave
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave


abstract class InPortSaveAbstractImpl<Entity: EntityI,Id:Any,SaveDto: SaveDtoI>
    : InPortSave<SaveDto>
{
    protected abstract val useCaseInPortSave: UseCaseSave<SaveDto>
}