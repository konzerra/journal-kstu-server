package com.konzerra.journal_kstu_server.domain.markdown.port.`in`.find_impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.InPortFindByIdFull
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindByIdFullAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.markdown.MarkdownApi
import com.konzerra.journal_kstu_server.domain.markdown.dto.MarkdownFullResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class MarkdownInPortFindByIdFullImpl(
    override val useCaseFindByIdFull: UseCaseFindByIdFull<MarkdownFullResponseDto, Long>
) : InPortFindByIdFullAbstractImpl<Long, MarkdownFullResponseDto>(){
    @GetMapping(MarkdownApi.findByIdFull)
    override fun execute(@PathVariable id: Long): Any {
        return ResponseEntity(
            useCaseFindByIdFull.execute(id),
            HttpStatus.OK,
        )
    }
}