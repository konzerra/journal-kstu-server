package com.konzerra.journal_kstu_server.domain.markdown.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownUpdateDto


@UseCase
class MarkdownUseCaseUpdateImpl(
    private val markdownOutPortFindById: OutPortFindById<Markdown,Long>,
    private val markdownOutPortSave: OutPortSave<Markdown>
) : UseCaseUpdate<MarkdownUpdateDto>{
    override fun execute(updateDto: MarkdownUpdateDto) {
        val markdown = markdownOutPortFindById.execute(updateDto.id)
        markdown.name = updateDto.name
        markdown.dataList=updateDto.dataList
        markdownOutPortSave.execute(markdown)
    }
}