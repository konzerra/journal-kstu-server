package com.konzerra.journal_kstu_server.domain.journal.usecase.find_impl

import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto
import com.konzerra.journal_kstu_server.domain.journal.port.out.JournalOutPortFindAllByStatus
import com.konzerra.journal_kstu_server.domain.journal.usecase.JournalUseCaseFindAllByStatus

@UseCase
class JournalUseCaseFindAllByStatusImpl(
    private val outPortFindAllByStatus: JournalOutPortFindAllByStatus,
) : JournalUseCaseFindAllByStatus {
    override fun execute(status: String, lang: String): List<JournalResponseDto> {
        return outPortFindAllByStatus.execute(status).map {
            JournalResponseDto.toResponseDto(
                entity = it,
                lang = lang
            )
        }
    }
}