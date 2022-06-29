package com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.util.Mapper


abstract class UseCaseFindByIdAbstractImpl<Entity: EntityI,Id:Any, ResponseDto: ResponseDtoI>
    : UseCaseFindById<Entity, Id, ResponseDto> {
    protected abstract val outPortFindById: OutPortFindById<Entity, Id>
    protected abstract val mapper: Mapper<Entity, ResponseDto>

    override fun execute(id: Id,lang:String): ResponseDto {
        return  mapper.toResponseDto(outPortFindById.execute(id),lang)
    }

}