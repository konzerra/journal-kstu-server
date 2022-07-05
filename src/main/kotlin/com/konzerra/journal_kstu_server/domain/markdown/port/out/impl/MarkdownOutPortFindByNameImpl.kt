package com.konzerra.journal_kstu_server.domain.markdown.port.out.impl

import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownRepository
import com.konzerra.journal_kstu_server.domain.markdown.port.out.MarkdownOutPortFindByName
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException


@OutPort
class MarkdownOutPortFindByNameImpl(
    private val repository: MarkdownRepository
) : MarkdownOutPortFindByName {
    override fun execute(name: String): Markdown {
        repository.findByName(name)?.let {markdown ->
            return markdown
        }
        throw ResourceNotFoundException(
            className = "Markdown",
            fieldName = "name",
            fieldValue = name
        )
    }
}