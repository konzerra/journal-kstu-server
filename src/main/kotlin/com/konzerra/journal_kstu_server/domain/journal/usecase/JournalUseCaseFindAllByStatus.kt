package com.konzerra.journal_kstu_server.domain.journal.usecase

import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto

interface JournalUseCaseFindAllByStatus {
    fun execute(status:String, lang:String):List<JournalResponseDto>
}