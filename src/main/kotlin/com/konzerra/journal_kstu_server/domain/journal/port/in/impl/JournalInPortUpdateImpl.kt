
package com.konzerra.journal_kstu_server.domain.journal.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortUpdateAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalUpdateDto
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@InPort
class JournalInPortUpdateImpl(
    override val useCaseUpdate: UseCaseUpdate<JournalUpdateDto>
) : InPortUpdateAbstractImpl<Journal, Long, JournalUpdateDto>() {

    @PutMapping(JournalApiPath.update)
    override fun execute(@RequestBody updateDto: JournalUpdateDto): ResponseEntity<*> {
        useCaseUpdate.execute(updateDto)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}
    