package com.konzerra.journal_kstu_server.domain.markdown.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.markdown.Markdown
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownRepository
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException

@OutPort
class MarkdownOutPortDeleteByIdImpl(
    private val repository: MarkdownRepository
) : OutPortDeleteById<Markdown,Long>{
    override fun execute(id: Long) {
        try{
            repository.deleteById(id)
        }catch(e:Exception){
            throw ResourceNotFoundException(
                className = "Markdown",
                fieldName = "Id",
                fieldValue = id
            )
        }

    }
}