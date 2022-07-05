package com.konzerra.journal_kstu_server.domain.markdown.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@OutPort
class MarkdownOutPortFindAllPaginatedImpl(
    private val repository: MarkdownRepository
) : OutPortFindAllPaginated<Markdown>{
    override fun execute(pageNumber: Int, pageSize: Int): Page<Markdown> {
        val pageable = PageRequest.of(pageNumber,pageSize, Sort.unsorted())
        return repository.findAll(pageable)
    }
}