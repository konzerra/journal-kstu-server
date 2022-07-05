package com.konzerra.journal_kstu_server.domain.markdown.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownRepository
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException

@OutPort
class MarkdownOutPortFindByIdImpl(
    private val repository: MarkdownRepository
) : OutPortFindById<Markdown,Long>{
    override fun execute(id: Long): Markdown {
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException(
                className = "Markdown",
                fieldName = "id",
                fieldValue = id
            )
        }
    }
}