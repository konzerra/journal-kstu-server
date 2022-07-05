package com.konzerra.journal_kstu_server.domain.markdown.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownRepository

@OutPort
class MarkdownOutPortSaveImpl(
    private val repository: MarkdownRepository
) : OutPortSave<Markdown>{
    override fun execute(entity: Markdown) {
        repository.save(entity)
    }
}