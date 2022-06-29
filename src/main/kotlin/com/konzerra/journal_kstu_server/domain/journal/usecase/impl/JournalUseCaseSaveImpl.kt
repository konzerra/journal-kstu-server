
package com.konzerra.journal_kstu_server.domain.journal.usecase.impl

import com.konzerra.journal_kstu_server._generic.port.out.crud.OutPortSave
import com.konzerra.journal_kstu_server._generic.usecase.abstract_impl.UseCaseSaveAbstractImpl
import com.konzerra.journal_kstu_server.annotation.UseCase
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.JournalStatus
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalSaveDto

@UseCase
class JournalUseCaseSaveImpl(
    override val outPortSave: OutPortSave<Journal>,
) : UseCaseSaveAbstractImpl<Journal,JournalSaveDto>(){
    override fun execute(saveDto: JournalSaveDto) {
        outPortSave.execute(
            Journal(
                dataList = saveDto.dataList,
                status = JournalStatus.Registered.toString(),
            )
        )
    }

}
    