package com.konzerra.journal_kstu_server.domain.markdown.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseDeleteByIdAbstractImpl
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.markdown.Markdown

@UseCase
class MarkdownUseCaseDeleteByIdImpl(
    override val outPortDeleteById: OutPortDeleteById<Markdown, Long>
) : UseCaseDeleteByIdAbstractImpl<Markdown,Long>(){
}