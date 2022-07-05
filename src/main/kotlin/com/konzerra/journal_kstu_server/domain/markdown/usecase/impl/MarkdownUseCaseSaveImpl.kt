package com.konzerra.journal_kstu_server.domain.markdown.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseSaveAbstractImpl
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownSaveDto

@UseCase
class MarkdownUseCaseSaveImpl(
    override val outPortSave: OutPortSave<Markdown>
):UseCaseSaveAbstractImpl<Markdown,MarkdownSaveDto>() {

    override fun execute(saveDto: MarkdownSaveDto) {
        outPortSave.execute(
            Markdown(
                name = saveDto.name,
                dataList = saveDto.dataList
            )
        )
    }


}