
package com.konzerra.journal_kstu_server.domain.category.port.`in`.find_impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryResponseDto
import com.konzerra.journal_kstu_server.domain.category.CategoryApiPath
    
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindById
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindByIdAbstractImpl

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@InPort
class CategoryInPortFindByIdImpl(
    override val useCaseFindById: UseCaseFindById<Category, Long, CategoryResponseDto>
) : InPortFindByIdAbstractImpl<Category, Long, CategoryResponseDto>() {

    @GetMapping(CategoryApiPath.findByIdPath)
    override fun execute(@PathVariable id: Long, @PathVariable lang: String): ResponseEntity<CategoryResponseDto> {
        return ResponseEntity(useCaseFindById.execute(id,lang),HttpStatus.OK)
    }

}
    