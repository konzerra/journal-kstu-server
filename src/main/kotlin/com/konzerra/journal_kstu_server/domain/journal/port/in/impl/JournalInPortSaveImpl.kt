
package com.konzerra.journal_kstu_server.domain.journal.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortSaveAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseSave
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalSaveDto
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath
    


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@InPort
class JournalInPortSaveImpl(
    override val useCaseInPortSave: UseCaseSave<JournalSaveDto>
) : InPortSaveAbstractImpl<Journal, Long, JournalSaveDto>() {

    @PostMapping(JournalApiPath.save)
    override fun execute(@RequestBody saveDto: JournalSaveDto): ResponseEntity<*> {
        useCaseInPortSave.execute(saveDto)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }
}
    