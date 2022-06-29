package com.konzerra.journal_kstu_server.domain.journal.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalFullResponseDto

@UseCase
class JournalUseCaseFindByIdFullImpl(
    private val outPortFindById:OutPortFindById<Journal,Long>
) : UseCaseFindByIdFull<JournalFullResponseDto, Long> {
    override fun execute(id: Long): JournalFullResponseDto {
        return JournalFullResponseDto.toResponseDto(outPortFindById.execute(id))
    }
}