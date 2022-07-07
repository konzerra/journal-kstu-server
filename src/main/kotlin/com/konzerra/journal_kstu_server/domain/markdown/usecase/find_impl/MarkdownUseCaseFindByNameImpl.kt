package com.konzerra.journal_kstu_server.domain.markdown.usecase.find_impl

import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownResponseDto
import com.konzerra.journal_kstu_server.domain.markdown.port.out.MarkdownOutPortFindByName
import com.konzerra.journal_kstu_server.domain.markdown.usecase.MarkdownUseCaseFindByName

@UseCase
class MarkdownUseCaseFindByNameImpl(
    private val markdownOutPortFindByName: MarkdownOutPortFindByName
) : MarkdownUseCaseFindByName {
    override fun execute(name: String, lang: String): MarkdownResponseDto {
        return MarkdownResponseDto.toResponseDto(
            markdownOutPortFindByName.execute(name),
            lang,
        )
    }
}