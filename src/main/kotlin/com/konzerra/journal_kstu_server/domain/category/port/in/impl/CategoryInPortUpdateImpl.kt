
package com.konzerra.journal_kstu_server.domain.category.port.`in`.impl

import com.konzerra.journal_kstu_server.annotation.InPort
import com.konzerra.journal_kstu_server.domain.category.Category
import com.konzerra.journal_kstu_server.domain.category.dto.CategoryUpdateDto
import com.konzerra.journal_kstu_server.domain.category.CategoryApiPath
    
import com.konzerra.journal_kstu_server._generic.port.`in`.crud.abstract_impl.InPortUpdateAbstractImpl
import com.konzerra.journal_kstu_server._generic.usecase.UseCaseUpdate

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@InPort
class CategoryInPortUpdateImpl(
    override val useCaseUpdate: UseCaseUpdate<CategoryUpdateDto>
) : InPortUpdateAbstractImpl<Category, Long, CategoryUpdateDto>() {

    @PutMapping(CategoryApiPath.updatePath)
    override fun execute(@RequestBody updateDto: CategoryUpdateDto): ResponseEntity<*> {
        useCaseUpdate.execute(updateDto)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}
    