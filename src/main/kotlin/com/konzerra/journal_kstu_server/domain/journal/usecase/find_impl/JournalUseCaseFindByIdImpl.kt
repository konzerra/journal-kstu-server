
package com.konzerra.journal_kstu_server.domain.journal.usecase.find_impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_find_impl.UseCaseFindByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.util.Mapper
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto


@UseCase
class JournalUseCaseFindByIdImpl(
    override val outPortFindById: OutPortFindById<Journal, Long>,
    override val mapper: Mapper<Journal, JournalResponseDto>
) : UseCaseFindByIdAbstractImpl<Journal, Long, JournalResponseDto>()
    