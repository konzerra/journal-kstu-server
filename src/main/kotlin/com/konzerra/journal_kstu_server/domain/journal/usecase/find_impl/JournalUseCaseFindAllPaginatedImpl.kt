package com.konzerra.journal_kstu_server.domain.journal.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindAllPaginated
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindAllPaginatedAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto

@UseCase
class JournalUseCaseFindAllPaginatedImpl(
    override val outPortFindAllPaginated: OutPortFindAllPaginated<Journal>,
    override val mapper: Mapper<Journal, JournalResponseDto>
): UseCaseFindAllPaginatedAbstractImpl<Journal, JournalResponseDto>() {
}