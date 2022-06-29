package com.konzerra.journal_kstu_server._generic.usecase.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.SaveDtoI
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave



abstract class UseCaseSaveAbstractImpl<Entity: EntityI,SaveDto: SaveDtoI>
     : UseCaseSave<SaveDto>
{
    protected abstract val outPortSave: OutPortSave<Entity>
}