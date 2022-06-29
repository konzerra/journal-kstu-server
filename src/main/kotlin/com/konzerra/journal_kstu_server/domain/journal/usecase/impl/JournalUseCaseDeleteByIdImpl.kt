
package com.konzerra.journal_kstu_server.domain.journal.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortDeleteById
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseDeleteByIdAbstractImpl
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.Journal


@UseCase
class JournalUseCaseDeleteByIdImpl(
    override val outPortDeleteById: OutPortDeleteById<Journal, Long>
) : UseCaseDeleteByIdAbstractImpl<Journal, Long>()
    