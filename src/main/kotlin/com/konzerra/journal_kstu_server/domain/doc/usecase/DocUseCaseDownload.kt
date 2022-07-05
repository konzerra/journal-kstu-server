package com.konzerra.journal_kstu_server.domain.doc.usecase

import com.konzerra.journal_kstu_server.domain.doc.Doc

interface DocUseCaseDownload {
    fun execute(id:Long): Doc
}