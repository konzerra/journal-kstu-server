package com.konzerra.journal_kstu_server.domain.doc.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.doc.Doc
import com.konzerra.journal_kstu_server.domain.doc.usecase.DocUseCaseDownload

@UseCase
class DocUseCaseDownloadImpl(
    private val docOutPortFindById: OutPortFindById<Doc,Long>
) : DocUseCaseDownload{
    override fun execute(id: Long): Doc {
        return docOutPortFindById.execute(id)
    }

}