package com.konzerra.journal_kstu_server.domain.markdown.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindAllPaginatedAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownResponseDto

@UseCase
class MarkdownUseCaseFindAllPaginatedImpl(
    override val outPortFindAllPaginated: OutPortFindAllPaginated<Markdown>,
    override val mapper: Mapper<Markdown, MarkdownResponseDto>
) : UseCaseFindAllPaginatedAbstractImpl<Markdown,MarkdownResponseDto>(){
}