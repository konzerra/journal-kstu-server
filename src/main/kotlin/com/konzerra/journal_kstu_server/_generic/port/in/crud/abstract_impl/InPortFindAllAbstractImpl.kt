package com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortFindAll
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindAll

abstract class InPortFindAllAbstractImpl<Entity: EntityI,ResponseDto: ResponseDtoI>
    : InPortFindAll<ResponseDto> {
    protected abstract val useCaseFindAll: UseCaseFindAll<Entity, ResponseDto>
}