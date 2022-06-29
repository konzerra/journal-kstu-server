
package com.konzerra.journal_kstu_server.domain.journal.port.`in`.find_impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindByIdAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindById
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.journal.Journal
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalResponseDto
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath
    


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class JournalInPortFindByIdImpl(
    override val useCaseFindById: UseCaseFindById<Journal, Long, JournalResponseDto>
) : InPortFindByIdAbstractImpl<Journal, Long, JournalResponseDto>() {

    @GetMapping(JournalApiPath.findById)
    override fun execute(@PathVariable id: Long, @PathVariable lang: String): ResponseEntity<JournalResponseDto> {
        return ResponseEntity(useCaseFindById.execute(id,lang),HttpStatus.OK)
    }

}
    