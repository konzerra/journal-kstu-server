package com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortFindByIdFull
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull

abstract class InPortFindByIdFullAbstractImpl<Id:Any,FullResponseDto:ResponseDtoI>
    : InPortFindByIdFull<Id>
{
    protected abstract val useCaseFindByIdFull: UseCaseFindByIdFull<FullResponseDto, Id>
}