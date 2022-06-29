
package com.konzerra.journal_kstu_server.domain.journal.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortFindById
import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseUpdateAbstractImpl
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalUpdateDto
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.Journal


@UseCase
class JournalUseCaseUpdateImpl(
    override val outPortSave: OutPortSave<Journal>,
    override val outPortFindById: OutPortFindById<Journal, Long>,
) : UseCaseUpdateAbstractImpl<Journal,Long,JournalUpdateDto>(){
    override fun execute(updateDto: JournalUpdateDto) {
        val journal = outPortFindById.execute(updateDto.id)
        journal.dataList = updateDto.dataList
        journal.status = updateDto.status
        outPortSave.execute(journal)
    }
}
    