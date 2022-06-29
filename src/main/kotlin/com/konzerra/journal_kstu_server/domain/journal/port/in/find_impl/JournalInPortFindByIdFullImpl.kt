package com.konzerra.journal_kstu_server.domain.journal.port.`in`.find_impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindByIdFullAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.journal.dto.JournalFullResponseDto
import com.konzerra.journal_kstu_server.domain.journal.JournalApiPath
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class JournalInPortFindByIdFullImpl(
    override val useCaseFindByIdFull: UseCaseFindByIdFull<JournalFullResponseDto, Long>
): InPortFindByIdFullAbstractImpl<Long, JournalFullResponseDto>() {

    @GetMapping(JournalApiPath.findByIdFull)
    override fun execute(@PathVariable id: Long): Any {
        return ResponseEntity(useCaseFindByIdFull.execute(id),HttpStatus.OK)
    }
}