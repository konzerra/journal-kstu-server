package com.konzerra.journal_kstu_server.domain.markdown.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindByIdFullAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownFullResponseDto


@UseCase
class MarkdownUseCaseFindByIdFull(
    override val outPortFindById: OutPortFindById<Markdown, Long>,
    override val mapper: Mapper<Markdown, MarkdownFullResponseDto>
) : UseCaseFindByIdFullAbstractImpl<Markdown, Long,MarkdownFullResponseDto>(){

}