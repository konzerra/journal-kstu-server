
package com.konzerra.journal_kstu_server.domain.category.port.`in`.find_impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryResponseDto
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.CategoryApiPath
    
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortFindAllAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseFindAll
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@InPort
class CategoryInPortFindAllImpl(
    override val useCaseFindAll: UseCaseFindAll<Category, CategoryResponseDto>
) : InPortFindAllAbstractImpl<Category, CategoryResponseDto>() {

    @GetMapping(CategoryApiPath.findAllPath)
    override fun execute(@RequestHeader("Accept-Language") lang: String): ResponseEntity<List<CategoryResponseDto>> {
        return ResponseEntity(useCaseFindAll.execute(lang),HttpStatus.OK)
    }
}
    