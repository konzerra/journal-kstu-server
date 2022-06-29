package com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server._generic.util.Mapper

abstract class UseCaseFindByIdFullAbstractImpl<
        Entity:EntityI,
        Id:Any,
        FullResponseDto:ResponseDtoI
        >
    : UseCaseFindByIdFull<FullResponseDto, Id> {
    protected abstract val outPortFindById: OutPortFindById<Entity,Id>
    protected abstract val mapper: Mapper<Entity,FullResponseDto>
    override fun execute(id: Id): FullResponseDto {
        return mapper.toResponseDto(outPortFindById.execute(id))
    }

}