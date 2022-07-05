package com.konzerra.journal_kstu_server.domain.doc.port.out.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.OutPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.doc.Doc
import com.konzerra.journal_kstu_server.domain.doc.DocRepository
import com.konzerra.journal_kstu_server.exception.ResourceNotFoundException

@OutPort
class DocOutPortFindByIdImpl(
    private val repository: DocRepository
) : OutPortFindById<Doc,Long>{
    override fun execute(id: Long): Doc {
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException(
                className = "Doc",
                fieldName = "id",
                fieldValue = id
            )
        }
    }

}