package com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl

import com.konzerra.journal_kstu_server._generic.data.EntityI
import com.konzerra.journal_kstu_server._generic.data.ResponseDtoI
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindAllPaginated
import com.konzerra.journal_kstu_server._generic.util.Mapper
import org.springframework.data.domain.Page

abstract class UseCaseFindAllPaginatedAbstractImpl<Entity:EntityI,ResponseDto : ResponseDtoI> : UseCaseFindAllPaginated<ResponseDto> {

    protected abstract  val outPortFindAllPaginated: OutPortFindAllPaginated<Entity>
    protected abstract val mapper: Mapper<Entity, ResponseDto>
    override fun execute(pageNumber: Int, pageSize: Int, lang: String): Page<ResponseDto> {
        val page:Page<ResponseDto> = outPortFindAllPaginated
            .execute(pageNumber,pageSize).map {
                mapper.toResponseDto(it,lang)
            }
        return page
    }
}