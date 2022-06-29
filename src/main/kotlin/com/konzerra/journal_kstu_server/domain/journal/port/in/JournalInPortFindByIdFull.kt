package com.konzerra.journal_kstu_server.domain.journal.port.`in`

import com.konzerra.journal_kstu_server.domain.journal.dto.JournalFullResponseDto

interface JournalInPortFindByIdFull {
    fun execute(id:Long):JournalFullResponseDto
}