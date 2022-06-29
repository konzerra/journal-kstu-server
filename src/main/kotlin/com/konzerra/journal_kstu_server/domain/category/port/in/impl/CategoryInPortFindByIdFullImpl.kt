package com.konzerra.journal_kstu_server.domain.category.port.`in`.impl

import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindByIdFullAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindByIdFull
import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryFullResponseDto
import com.konzerra.journal_kstu_server.domain.category.CategoryApiPath
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class CategoryInPortFindByIdFullImpl(
    override val useCaseFindByIdFull: UseCaseFindByIdFull<CategoryFullResponseDto, Long>
): InPortFindByIdFullAbstractImpl<Long, CategoryFullResponseDto>() {

    @GetMapping(CategoryApiPath.findByIdPathFull)
    override fun execute(@PathVariable id: Long): ResponseEntity<CategoryFullResponseDto> {
        return ResponseEntity(useCaseFindByIdFull.execute(id),HttpStatus.OK)
    }
}